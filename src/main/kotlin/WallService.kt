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
        for (post in posts) {
            if (post.id == updatePost.id) {
                val newUpdatePost: Post = post.copy(
                    owner_id = updatePost.owner_id,
                    from_id = updatePost.from_id,
                    created_by = updatePost.created_by,
                    text = updatePost.text,
                    reply_owner_id = updatePost.reply_owner_id,
                    reply_post_id = updatePost.reply_post_id,
                    friends_only = updatePost.friends_only,
                    comments = updatePost.comments,
                    likes = updatePost.likes,
                    reposts = updatePost.reposts,
                    views = updatePost.views,
                    post_type = updatePost.post_type,
                    signer_id = updatePost.signer_id,
                    can_pin = updatePost.can_pin,
                    can_delete = updatePost.can_delete,
                    can_edit = updatePost.can_edit,
                    is_pinned = updatePost.is_pinned,
                    marked_as_ads = updatePost.marked_as_ads,
                    is_favorite = updatePost.is_favorite,
                    postponed_id = updatePost.postponed_id
                )
                posts.remove(post)
                posts += newUpdatePost
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