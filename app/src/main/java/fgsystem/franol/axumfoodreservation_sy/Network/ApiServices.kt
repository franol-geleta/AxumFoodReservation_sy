package fgsystem.franol.axumfoodreservation_sy.Network

import android.graphics.Movie
import fgsystem.franol.axumfoodreservation_sy.data.Food
import fgsystem.franol.axumfoodreservation_sy.data.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

interface ApiServices {



    @POST("public/userlogin")
    fun validate(user: User):Call<User>
    @GET("public/allusers")
    fun getallusers(user: User): Call<User>

    @PUT("public/updateuser/{id}")
    fun changeusername(user: User): Call<User>

    @PUT("public/updatepassword")
    fun changepassword(user: User): Call<User>



    @GET("/launch/launch.php/createfood")
    fun getAllFoods(): Call<List<Food>>

    @PUT("/launch/launch.php/updatefood/{id}")
    fun updateFood(@Body newfood : Food):Call<Food>


    companion object {

        private val baseUrl = "http://192.168.43.50/axumfoodapp/"

        fun getInstance(): ApiServices {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

            return retrofit.create(ApiServices::class.java)
        }
    }

    @FormUrlEncoded
    @POST("createuser")
    abstract fun createUser(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("name") name: String,
        @Field("school") school: String)
//            : Call<DefaultResponse>

    @FormUrlEncoded
    @POST("userlogin")
    abstract fun userLogin(
        @Field("email") email: String,
        @Field("password") password: String)
//            : Call<LoginResponse>

    @GET("allusers")
    abstract fun getUsers()
//            : Call<UsersResponse>

    @FormUrlEncoded
    @PUT("updateuser/{id}")
    abstract fun updateUser(
        @Path("id") id: Int,
        @Field("email") email: String,
        @Field("name") name: String,
        @Field("school") school: String)
//            : Call<LoginResponse>

    @FormUrlEncoded
    @PUT("updatepassword")
    abstract fun updatePassword(
        @Field("currentpassword") currentpassword: String,
        @Field("newpassword") newpassword: String,
        @Field("email") email: String)
//            : Call<DefaultResponse>

    @DELETE("deleteuser/{id}")
    abstract fun deleteUser(@Path("id") id: Int)
//            : Call<DefaultResponse>

}
