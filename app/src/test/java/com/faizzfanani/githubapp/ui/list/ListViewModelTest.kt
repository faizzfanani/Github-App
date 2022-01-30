package com.faizzfanani.githubapp.ui.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.faizzfanani.githubapp.data.repository.FakeRepository
import com.faizzfanani.githubapp.data.source.local.FakeLocalDataSource
import com.faizzfanani.githubapp.data.source.local.entity.UserEntity
import com.faizzfanani.githubapp.data.source.remote.FakeRemoteDataSource
import com.faizzfanani.githubapp.utils.AppExecutor
import com.faizzfanani.githubapp.utils.DataDummy
import com.faizzfanani.githubapp.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class ListViewModelTest{
    private val appExecutor = mock(AppExecutor::class.java)
    private lateinit var localDataSource : FakeLocalDataSource
    private lateinit var remoteDataSource: FakeRemoteDataSource
    private lateinit var viewModel : ListViewModel
    private lateinit var userList : List<UserEntity>
    private lateinit var repository : FakeRepository

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        localDataSource = FakeLocalDataSource()
        remoteDataSource = FakeRemoteDataSource()
        userList = DataDummy.userList
        repository = FakeRepository(localDataSource, remoteDataSource, appExecutor)
        viewModel = ListViewModel(repository)
    }

    @Test
    fun `get user list`(){
        //given
        localDataSource.addUsers(userList)
        //when
        var result : Resource<List<UserEntity>>? = null
        viewModel.getUserList().observeForever {
            result = it
        }
        //then
        assertNotNull(result?.data)
        assertEquals(userList, result?.data)
    }
}