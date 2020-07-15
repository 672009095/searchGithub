package rama.id.searchgithub.data.module

import org.koin.core.qualifier.named
import org.koin.dsl.module
import rama.id.searchgithub.BuildConfig
import rama.id.searchgithub.data.common.entity.RetrofitType
import rama.id.searchgithub.data.search.cloud.SearchApi
import retrofit2.Retrofit

/**
 * this file is for grouping call API builder to retrofit
 * can use type based on retrofit type (use token or not use token)
 */
val apiModule = module{
    single{
        get<Retrofit.Builder>(named(RetrofitType.DEFAULT.value))
            .baseUrl(BuildConfig.BASE_URL)
            .build()
            .create(SearchApi::class.java)
    }
}