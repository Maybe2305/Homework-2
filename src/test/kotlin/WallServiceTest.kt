import org.junit.Assert.*
import org.junit.Before

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
}