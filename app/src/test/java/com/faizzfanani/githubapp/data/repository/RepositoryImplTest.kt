package com.faizzfanani.githubapp.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.faizzfanani.githubapp.data.source.local.FakeLocalDataSource
import com.faizzfanani.githubapp.data.source.local.entity.RepositoryEntity
import com.faizzfanani.githubapp.data.source.local.entity.UserDetailEntity
import com.faizzfanani.githubapp.data.source.local.entity.UserEntity
import com.faizzfanani.githubapp.data.source.remote.FakeRemoteDataSource
import com.faizzfanani.githubapp.utils.AppExecutor
import com.faizzfanani.githubapp.utils.DataDummy
import com.faizzfanani.githubapp.vo.Resource
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class RepositoryImplTest {
    private lateinit var userList: List<UserEntity>
    private lateinit var repositoryList: List<RepositoryEntity>
    private lateinit var userEntity: UserDetailEntity
    private val appExecutor = mock(AppExecutor::class.java)
    private lateinit var localDataSource: FakeLocalDataSource
    private lateinit var remoteDataSource: FakeRemoteDataSource
    private lateinit var repository: Repository

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init(){
        userList = DataDummy.userList
        repositoryList = DataDummy.repos
        userEntity = DataDummy.userEntity
        localDataSource = FakeLocalDataSource()
        remoteDataSource = FakeRemoteDataSource()
        repository = FakeRepository(localDataSource, remoteDataSource, appExecutor)
    }
    @Test
    fun testGetUserList() {
        localDataSource.addUsers(userList)
        var result : Resource<List<UserEntity>>? = null
        repository.getUserList().observeForever {
            result = it
        }
        assertNotNull(result?.data)
        assertEquals(userList, result?.data)
    }
    @Test
    fun testGetUserDetails() {
        localDataSource.addUser(userEntity)
        var result : Resource<UserDetailEntity>? = null
        repository.getUserDetails("faizzfanani").observeForever {
            result = it
        }
        assertNotNull(result?.data)
        assertEquals(userEntity, result?.data)
    }
    @Test
    fun testGetRepos() {
        localDataSource.addRepos(repositoryList)
        var result : Resource<List<RepositoryEntity>>? = null
        repository.getRepos("pjhyett").observeForever {
            result = it
        }
        assertNotNull(result?.data)
        assertEquals(repositoryList, result?.data)
    }
}