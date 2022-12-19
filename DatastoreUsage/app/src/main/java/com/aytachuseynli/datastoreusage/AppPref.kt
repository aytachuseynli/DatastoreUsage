package com.aytachuseynli.datastoreusage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class AppPref(var context: Context) {
    val Context.ds : DataStore<Preferences> by preferencesDataStore("info")

    companion object{
        val NAME_KEY = stringPreferencesKey("NAME")
        val COUNTER_KEY = intPreferencesKey("COUNTER")
    }

    suspend fun saveName(name:String) {
        context.ds.edit{
            it[NAME_KEY] = name
        }
    }

    suspend fun saveCounter(counter:Int) {
        context.ds.edit{
            it[COUNTER_KEY] = counter
        }
    }

    suspend fun readName():String {
        val p = context.ds.data.first()
        return p[NAME_KEY] ?: "No NAME"
    }

    suspend fun readCounter():Int {
        val p = context.ds.data.first()
        return p[COUNTER_KEY] ?: 0

    }

    suspend fun deleteName() {
        context.ds.edit{
            it.remove(NAME_KEY)
        }
    }

}