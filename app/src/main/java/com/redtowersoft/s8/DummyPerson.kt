package com.redtowersoft.s8

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DummyPerson(val name: String, val surname: String, val age: Int) : Parcelable