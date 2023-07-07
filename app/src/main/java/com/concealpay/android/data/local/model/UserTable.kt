package com.concealpay.android.data.local.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "user_table")
data class UserTable(
    @PrimaryKey(autoGenerate = true)
    var userId: Int,
    var msisdn: String,
    var name: String
): Parcelable
