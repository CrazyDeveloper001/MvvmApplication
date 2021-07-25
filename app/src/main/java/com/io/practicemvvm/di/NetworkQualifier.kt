package com.io.practicemvvm.di

import javax.inject.Qualifier


object NetworkQualifier {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class BaseUrl
}