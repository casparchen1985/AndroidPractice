package com.casparchen.androidpractice

import com.google.gson.annotations.SerializedName

data class RowPackage (
    @SerializedName("XML_Head")
    var data: RowData
)

data class RowData (
    @SerializedName("Listname")
    var rowListname: String,
    @SerializedName("Language")
    var rowLanguage: String,
    @SerializedName("Orgname")
    var rowOrgname: String,
    @SerializedName("Updatetime")
    var rowUpdatetime: String,
    @SerializedName("Infos")
    var rowInfosObject: RowInfosObject
    )

data class RowInfosObject (
    @SerializedName("Info")
    var rowList: List<RowRestaurant>
)

data class RowRestaurant (
    @SerializedName("Id")
    var rowID: String,
    @SerializedName("Name")
    var rowName: String = "Default Name",
    @SerializedName("Description")
    var rowDescription: String,
    @SerializedName("Add")
    var rowAdd: String,
    @SerializedName("Zipcode")
    var rowZipcode: String,
    @SerializedName("Region")
    var rowRegion: String,
    @SerializedName("Town")
    var rowTown: String,
    @SerializedName("Tel")
    var rowTel: String,
    @SerializedName("Opentime")
    var rowOpentime: String,
    @SerializedName("Website")
    var rowWebsite: String,
    @SerializedName("Picture1")
    var rowPic1: String,
    @SerializedName("Picdescribe1")
    var rowPic1Des: String,
    @SerializedName("Picture2")
    var rowPic2: String,
    @SerializedName("Picdescribe2")
    var rowPic2Des: String,
    @SerializedName("Picture3")
    var rowPic3: String,
    @SerializedName( "Picdescribe3")
    var rowPic3Des: String,
    @SerializedName( "Px")
    var rowPx: Double,
    @SerializedName("Py")
    var rowPy: Double,
    @SerializedName( "Class")
    var rowClass: String,
    @SerializedName( "Map")
    var rowMap: String,
    @SerializedName("Parkinginfo")
    var rowParking: String
)