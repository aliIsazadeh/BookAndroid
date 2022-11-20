package com.example.bookandroid.authfeature.common

object Constants {

    const val BASE_URL = "http://127.0.0.1:8080/"

    const val AUTH_URL = "${BASE_URL}auth/"

    const val REGISTER_URL = "${AUTH_URL}register/"
    const val REGISTER_BY_EMAIL_URL = "${REGISTER_URL}email"
    const val TEST_API = "http://192.168.1.7:8081/"
    const val REGISTER_BY_PHONE_NUMBER_URL = "${REGISTER_URL}phoneNumber"

    const val CHECK_USERNAME = "${REGISTER_URL}username"

    const val LOGIN_URL = "${AUTH_URL}login/"
    const val LOGIN_EMAIL = "${LOGIN_URL}email"
    const val LOGIN_PHONE_NUMBER = "${LOGIN_URL}phoneNumber"
    const val LOGIN_USERNAME = "${LOGIN_URL}username"




    const val SITE_ID = "20121"

    const val EMAIL_SIGN_IN_URL = "email"

    const val PHONE_NUMBER = "email"

    const val PASSWORD = "email"

    const val USER_NAME = "email"

    const val CODE = "email"

    const val PHONE_NUMBER_LENGTH = 11

}