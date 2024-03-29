package com.example.openmind.data.repository

import com.example.openmind.domain.api.CommentsServices
import com.example.openmind.domain.model.comment.CommentModel
import com.example.openmind.domain.model.comment.CreateCommentModel
import com.example.openmind.domain.model.comment.dto.CommentDto
import com.example.openmind.domain.model.mapper.provider.CommentMapperProvider
import com.example.openmind.domain.model.mapper.provider.CreateCommentMapperProvider
import com.example.openmind.domain.repository.Repository
import com.example.openmind.utils.WebClientUtils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CommentsRepository : Repository<CommentDto> {
    private val retrofit = WebClientUtils.getRetrofitInstance()
    private var service: CommentsServices = retrofit.create(CommentsServices::class.java)


    override suspend fun fetchById(id: String): Flow<CommentDto> {
        TODO("Not yet implemented")
    }


    suspend fun postComment(createCommentModel: CreateCommentModel) {
        val createModelDto = CreateCommentMapperProvider.provideMapper().toDto(createCommentModel)
        service.createPost(createModelDto)
    }

    suspend fun fetchCommentsByPostId(currentPostId: String): Flow<List<CommentModel>> {
        return flow {
            val response = service.getCommentsByPostId(currentPostId).execute()
            if (response.isSuccessful) {
                val responseBody = response.body()
                val comments = responseBody ?: emptyList()
                val models = comments.map(CommentMapperProvider.provideCommentMapper()::fromDto)
                emit(models)
            } else {
                emit(emptyList())
            }
        }
    }

}
