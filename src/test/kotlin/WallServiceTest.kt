import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @org.junit.Test
    fun idIsNotZero() {
        val post = Post(id = 0, text = "Hello World")
        val addedPost = WallService.add(post)
        assertNotEquals(0, addedPost.id)
    }


    @org.junit.Test
    fun updatePostReturnTrue() {
        val post = Post(id = 1, text = "Hello World")
        WallService.add(post)
        val updatedPost = post.copy(text = "Updated Post")
        val result = WallService.update(updatedPost)
        assertTrue(result)
    }

    @org.junit.Test
    fun updatePostReturnFalse() {
        val post = Post(id = 1, text = "Hello World")
        val result = WallService.update(post)
        assertEquals(false, result)
    }

    @Test
    fun createComment() {
        val postId = 1
        val post = Post()
        WallService.add(post)

        val comment = Comments(text = "Hello")
        val result = WallService.createComment(1, comment)
        assertEquals("Hello", result.text)
    }

    @Test(expected = PostNotFoundException::class)
    fun createCommentWithException() {
        val postId = 1
        val post = Post()
        WallService.add(post)

        val comment = Comments(text = "Hello")
        val result = WallService.createComment(2, comment)
        assertEquals(PostNotFoundException("No post with id: $postId"), result.text)
    }

}