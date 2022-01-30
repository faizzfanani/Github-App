package com.faizzfanani.githubapp.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.faizzfanani.githubapp.data.repository.FakeRepository
import com.faizzfanani.githubapp.data.source.local.FakeLocalDataSource
import com.faizzfanani.githubapp.data.source.local.entity.RepositoryEntity
import com.faizzfanani.githubapp.data.source.local.entity.UserDetailEntity
import com.faizzfanani.githubapp.data.source.remote.FakeRemoteDataSource
import com.faizzfanani.githubapp.utils.AppExecutor
import com.faizzfanani.githubapp.utils.DataDummy
import com.faizzfanani.githubapp.vo.Resource
import junit.framework.TestCase.assertNotNull
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class DetailViewModelTest{
    private val appExecutor = mock(AppExecutor::class.java)
    private lateinit var localDataSource : FakeLocalDataSource
    private lateinit var remoteDataSource: FakeRemoteDataSource
    private lateinit var viewModel : DetailViewModel
    private lateinit var userDetail : UserDetailEntity
    private lateinit var repositoryList : List<RepositoryEntity>
    private lateinit var repository : FakeRepository

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        localDataSource = FakeLocalDataSource()
        remoteDataSource = FakeRemoteDataSource()
        userDetail = DataDummy.userEntity
        repositoryList = DataDummy.repos
        repository = FakeRepository(localDataSource, remoteDataSource, appExecutor)
        viewModel = DetailViewModel(repository)
    }
    @Test
    fun `get detail user`(){
        localDataSource.addUser(userDetail)
        var result : Resource<UserDetailEntity>? = null
        viewModel.getUserDetails("faizzfanani").observeForever {
            result = it
        }
        assertNotNull(result?.data)
        assertEquals(userDetail, result?.data)
    }
    @Test
    fun `get repository list`(){
        localDataSource.addRepos(repositoryList)
        var result : Resource<List<RepositoryEntity>>? = null
        viewModel.getRepos("pjhyett").observeForever {
            result = it
        }
        assertNotNull(result?.data)
        assertEquals(repositoryList, result?.data)
    }
}