package com.example.proyecto.GermoplasmaAPIService

import com.example.proyecto.GermoplasmaAPIService.JSONResponseToDataClass.*
import com.example.proyecto.GermoplasmaAPIService.DataClasses.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface APIService {

    @GET("pedregosidad/")
    fun getPedregosidad(@Header("Authorization") authorization : String,
                        @Header("X-Request-ID") requestId : String)
    : Call<JSONResponsePedregosidad>

    @GET("rocosidad/")
    fun getRocosidad(@Header("Authorization") authorization : String,
                     @Header("X-Request-ID") requestId : String)
    : Call<JSONResponseRocosidad>

    @GET("textura/")
    fun getTextura(@Header("Authorization") authorization : String,
                   @Header("X-Request-ID") requestId : String)
    : Call<JSONResponseTextura>

    @GET("categorias/")
    fun getCategorias(@Header("Authorization") authorization : String,
                      @Header("X-Request-ID") requestId : String)
    : Call<JSONResponseCategorias>

    @GET("hojarasca/")
    fun getHojarasca(@Header("Authorization") authorization : String,
                     @Header("X-Request-ID") requestId : String)
    : Call<JSONResponseHojarasca>

    @GET("tiposuelo/")
    fun getTipoSuelo(@Header("Authorization") authorization : String,
                     @Header("X-Request-ID") requestId : String)
    : Call<JSONResponseTipoSuelo>

    @GET("topografia")
    fun getTopografia(@Header("Authorization") authorization : String,
                      @Header("X-Request-ID") requestId : String)
    : Call<JSONResponseTopografia>

    @GET("coberturavegetal/")
    fun getCoberturaVegetal(@Header("Authorization") authorization : String,
                            @Header("X-Request-ID") requestId : String)
    : Call<JSONResponseCoberturaVegetal>

    @GET("amenazas/")
    fun getAmenazas(@Header("Authorization") authorization : String,
                    @Header("X-Request-ID") requestId : String)
    : Call<JSONResponseAmenazas>

    @GET("especies/")
    fun getEspecies(@Header("Authorization") authorization : String,
                    @Header("X-Request-ID") requestId : String)
    : Call<JSONResponseEspecies>

    @GET("comunidadesautonomas/")
    fun getComunidadesAutonomas(@Header("Authorization") authorization : String,
                                @Header("X-Request-ID") requestId : String)
    : Call<JSONResponseComunidadesAutonomas>

    @GET("provincias/")
    fun getProvincias(@Header("Authorization") authorization : String,
                      @Header("X-Request-ID") requestId : String)
    : Call<JSONResponseProvincias>

    @GET("muestras/")
    fun getMuestras(@Header("Authorization") authorization : String,
                    @Header("X-Request-ID") requestId : String)
    : Call<JSONResponseMuestras>

    @GET("accesiones/")
    fun getAccesiones(@Header("Authorization") authorization : String,
                      @Header("X-Request-ID") requestId : String)
    : Call<JSONResponseAccesiones>

    @GET ("accesion/{id}")
    fun getAccesionById(@Path("id") id: Int, @Header("Authorization") authorization : String, @Header("X-Request-ID") requestId : String): Call<JSONResponseAccesiones>

    @GET("imagenes/")
    fun getImagenes (@Header("Authorization") authorization : String,
                     @Header("X-Request-ID") requestId : String,
                     @Query("idMuestra") idMuestra: Int)
    : Call<JSONResponseImagenes>

    @Streaming
    @GET("imagen/{idImagen}")
    fun getImagenByID(@Header("Authorization") authorization : String, @Header("X-Request-ID") requestId : String,
                    @Path("idImagen") idImagen: Int)
    : Call<ResponseBody>

    @GET("estadosmuestra/")
    fun getEstadoMuestra (@Header("Authorization") authorization : String,
                          @Header("X-Request-ID") requestId : String)
    : Call<JSONResponseEstadoMuestra>

    @GET("valoresph/")
    fun getValoresPH (@Header("Authorization") authorization : String,
                      @Header("X-Request-ID") requestId : String)
    : Call<JSONResponseValoresPH>

    @GET("materiaorganica/")
    fun getMateriaOrganica (@Header("Authorization") authorization : String,
                            @Header("X-Request-ID") requestId : String)
    : Call<JSONResponseMateriaOrganica>

    @GET("version/")
    fun getVersion (@Header("Authorization") authorization : String,
                    @Header("X-Request-ID") requestId : String)
    : Call<JSONResponseVersion>


    @POST("accesion/")
    fun setAccesion(@Header("Authorization") authorization : String,
                    @Header("X-Request-ID") requestId : String,
                    @Body accesion: AccesionPOST)
    : Call<JSONResponseAccesionesPOST>

    @POST("muestra/")
    fun setMuestra(@Header("Authorization") authorization : String,
                   @Header("X-Request-ID") requestId : String,
                   @Body muestra: MuestraPOST)
    : Call<JSONResponseMuestrasPOST>

    @Multipart
    @POST("imagen/")
    fun setImagen(@Header("Authorization") authorization : String, @Header("X-Request-ID") requestId : String,
                  @Part("idMuestra") idMuestra: RequestBody,
                  @Part body: MultipartBody.Part)
    : Call<JSONResponseImagenPOST>

    @PUT("accesion/{idAccesion}")
    fun putAccesion(@Header("Authorization") authorization : String,
                    @Header("X-Request-ID") requestId : String,
                    @Path("idAccesion") idAccesion: Int,
                    @Body accesion: AccesionPUT)
    : Call<JSONResponseAccesionPUT>


    companion object {

        var BASE_URL = "http://germoplasma.perentec.com/api/"

        fun create(): APIService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(APIService::class.java)
        }
    }

}

