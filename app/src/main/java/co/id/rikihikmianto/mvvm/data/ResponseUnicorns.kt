package co.id.rikihikmianto.mvvm.data

import com.google.gson.annotations.SerializedName

data class ResponseUnicorns(

	@field:SerializedName("colour")
	val colour: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("age")
	val age: Int? = null
)
