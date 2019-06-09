package fgsystem.franol.axumfoodreservation_sy.Network

import retrofit2.Call
import retrofit2.http.*

interface ApiServices {

    @FormUrlEncoded
    @POST("createuser")
    abstract fun createUser(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("name") name: String,
        @Field("school") school: String
    ): Call<DefaultResponse>

    @FormUrlEncoded
    @POST("userlogin")
    abstract fun userLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @GET("allusers")
    abstract fun getUsers(): Call<UsersResponse>

    @FormUrlEncoded
    @PUT("updateuser/{id}")
    abstract fun updateUser(
        @Path("id") id: Int,
        @Field("email") email: String,
        @Field("name") name: String,
        @Field("school") school: String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @PUT("updatepassword")
    abstract fun updatePassword(
        @Field("currentpassword") currentpassword: String,
        @Field("newpassword") newpassword: String,
        @Field("email") email: String
    ): Call<DefaultResponse>

    @DELETE("deleteuser/{id}")
    abstract fun deleteUser(@Path("id") id: Int): Call<DefaultResponse>

}
