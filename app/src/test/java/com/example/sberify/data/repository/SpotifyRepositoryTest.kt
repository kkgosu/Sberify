package com.example.sberify.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.sberify.MockTestUtils.Companion.mockAlbumsData
import com.example.sberify.data.Result
import com.example.sberify.data.api.SpotifyApi
import com.example.sberify.data.db.AppDatabase
import com.example.sberify.data.db.album.AlbumDao
import com.example.sberify.models.domain.Album
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response

@RunWith(JUnit4::class)
class SpotifyRepositoryTest {

    private val dataConverter: DataConverter = mock()
    private val database: AppDatabase = mock()
    private val spotifyApi: SpotifyApi = mock()

    private val repo: SpotifyRepositoryImpl = SpotifyRepositoryImpl(dataConverter, database, spotifyApi)

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @Test
    fun getToken() = runBlocking {

        return@runBlocking
    }

    @Test
    fun getNewReleases() = runBlocking {
        val albumDao = mock<AlbumDao>()

        whenever(spotifyApi.getNewReleases()).thenReturn(Response.success(mockAlbumsData()))
        whenever(database.getAlbumDao()).thenReturn(albumDao)

        val data = repo.getNewReleases()
        val observer = mock<Observer<Result<List<Album>>>>()
        data.observeForever(observer)
        verify(database).getAlbumDao()
        return@runBlocking
    }

    @Test
    fun getAlbumInfo() {
    }

    @Test
    fun searchArtist() {
    }

    @Test
    fun searchAlbum() {
    }

    @Test
    fun searchTrack() {
    }
}