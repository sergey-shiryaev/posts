package ru.netology

object WallService {
    private var posts = arrayListOf<Post>()
    private var postsID = 1

    fun add(newPost: Post): Post {
        newPost.id = postsID
        postsID++
        posts += newPost
        return newPost
    }

    fun update(updatePost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == updatePost.id) {
                val newUpdatePost: Post = post.copy(
                    owner_id = updatePost.owner_id,
                    text = updatePost.text,
                    comments = updatePost.comments,
                    likes = updatePost.likes,
                    reposts = updatePost.reposts,
                    views = updatePost.views,
                    post_type = updatePost.post_type,
                    signer_id = updatePost.signer_id,
                    is_pinned = updatePost.is_pinned,
                    marked_as_ads = updatePost.marked_as_ads,
                    is_favorite = updatePost.is_favorite
                )
                posts[index] = newUpdatePost
                return true
            }
        }
        return false
    }

    fun clearPosts() {
        posts.clear()
        postsID = 1
    }
}