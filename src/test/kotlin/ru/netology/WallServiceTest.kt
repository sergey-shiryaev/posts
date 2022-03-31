package ru.netology

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Before
    fun clearService() {
        WallService.clearPosts()
    }

    @Test
    fun afterAddIdNotZero() {
        val service = WallService
        val expectedID = 1
        val post = Post(
            owner_id = 10,
            from_id = 20,
            created_by = 30,
            date = 0,
            text = "This is the post",
            reply_owner_id = 100,
            reply_post_id = 101,
            friends_only = true,
            comments = "This is a good post",
            likes = 2,
            reposts = 5,
            views = 1,
            post_type = "post",
            signer_id = 1,
            can_pin = true,
            can_delete = true,
            can_edit = true,
            is_pinned = true,
            marked_as_ads = true,
            is_favorite = true,
            postponed_id = 0
        )
        service.add(post)
        assertEquals(expectedID, post.id)
    }

    @Test
    fun updateExisting() {
        val service = WallService
        service.add(
            Post(
                owner_id = 10,
                from_id = 20,
                created_by = 30,
                date = 0,
                text = "This is the post",
                reply_owner_id = 100,
                reply_post_id = 101,
                friends_only = true,
                comments = "This is a good post",
                likes = 2,
                reposts = 5,
                views = 1,
                post_type = "post",
                signer_id = 1,
                can_pin = true,
                can_delete = true,
                can_edit = true,
                is_pinned = true,
                marked_as_ads = true,
                is_favorite = true,
                postponed_id = 0
            )
        )
        service.add(
            Post(
                owner_id = 10000,
                from_id = 20,
                created_by = 30,
                date = 0,
                text = "This is the post",
                reply_owner_id = 100,
                reply_post_id = 101,
                friends_only = true,
                comments = "This is a good post",
                likes = 2,
                reposts = 5,
                views = 1,
                post_type = "post",
                signer_id = 1,
                can_pin = true,
                can_delete = true,
                can_edit = true,
                is_pinned = true,
                marked_as_ads = true,
                is_favorite = true,
                postponed_id = 0
            )
        )
        val update = Post(
            id = 2,
            owner_id = 0,
            from_id = 0,
            created_by = 0,
            date = 66666,
            text = "post",
            reply_owner_id = 0,
            reply_post_id = 0,
            friends_only = true,
            comments = "post",
            likes = 0,
            reposts = 0,
            views = 0,
            post_type = "post",
            signer_id = 0,
            can_pin = true,
            can_delete = true,
            can_edit = true,
            is_pinned = true,
            marked_as_ads = true,
            is_favorite = true,
            postponed_id = 0
        )
        val result = service.update(update)
        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {
        val service = WallService
        service.add(
            Post(
                owner_id = 10,
                from_id = 20,
                created_by = 30,
                date = 0,
                text = "This is the post",
                reply_owner_id = 100,
                reply_post_id = 101,
                friends_only = true,
                comments = "This is a good post",
                likes = 2,
                reposts = 5,
                views = 1,
                post_type = "post",
                signer_id = 1,
                can_pin = true,
                can_delete = true,
                can_edit = true,
                is_pinned = true,
                marked_as_ads = true,
                is_favorite = true,
                postponed_id = 0
            )
        )
        service.add(
            Post(
                owner_id = 10000,
                from_id = 20,
                created_by = 30,
                date = 0,
                text = "This is the post",
                reply_owner_id = 100,
                reply_post_id = 101,
                friends_only = true,
                comments = "This is a good post",
                likes = 2,
                reposts = 5,
                views = 1,
                post_type = "post",
                signer_id = 1,
                can_pin = true,
                can_delete = true,
                can_edit = true,
                is_pinned = true,
                marked_as_ads = true,
                is_favorite = true,
                postponed_id = 0
            )
        )
        val update = Post(
            id = 3,
            owner_id = 0,
            from_id = 0,
            created_by = 0,
            date = 66666,
            text = "post",
            reply_owner_id = 0,
            reply_post_id = 0,
            friends_only = true,
            comments = "post",
            likes = 0,
            reposts = 0,
            views = 0,
            post_type = "post",
            signer_id = 0,
            can_pin = true,
            can_delete = true,
            can_edit = true,
            is_pinned = true,
            marked_as_ads = true,
            is_favorite = true,
            postponed_id = 0
        )
        val result = service.update(update)
        assertFalse(result)
    }
}