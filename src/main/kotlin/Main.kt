import javax.xml.stream.events.Comment

data class Post(
    val id: Int? = 1,
    val ownerId: Int? = 1,
    val fromId: Int = 2,
    val text: String? = "Just post",
    val replyOwnerId: Int = 2,
    val signerId: Int = 1,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = false,
    val attachments: Array<Attachment> = emptyArray<Attachment>()
)

data class Comments(
    val id: Int = 1,
    val text: String,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = true,
    val canOpen: Boolean = true
)

object WallService {
    var posts = emptyArray<Post>()
    private var comments = emptyArray<Comments>()

    private var idPost = 1

    fun createComment(postId: Int, comment: Comments): Comments {
        for (post in posts) {
            if (post.id == postId) {
                comments += comment
                return comments.last()
            }
        }
        return throw PostNotFoundException("No post with id: $postId")
    }

    fun add(post: Post): Post {
        val newPost = post.copy(id = idPost++)
        posts += newPost
        return newPost
    }

    fun update(post: Post): Boolean {
        val index = posts.indexOfFirst { it.id == post.id }
        if (index >= 0) {
            posts[index] = post
            return true
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        idPost = 1
    }
}

fun main() {
    val post1 = Post()
    WallService.add(post1)
    println(post1)

    val post2 = Post(id = 2)
    WallService.add(post2)
    println(post2)

    val updatedPost = Post(text = "Updated Post")
    val isUpdate = WallService.update(updatedPost)
    println(isUpdate)
}

class PostNotFoundException(message: String) : RuntimeException(message)

interface Attachment {
    val type: String
}


data class VideoAttachment(
    override val type: String,
    val video: Video
) : Attachment

data class StickerAttachment(
    override val type: String,
    val sticker: Sticker
) : Attachment

data class PhotoAttachment(
    override val type: String,
    val photo: Photo
) : Attachment

data class Video(
    val id: Int,
    val title: String,
    val duration: Double,
    val views: Int,
    val canAdd: Boolean
)

data class Sticker(
    val productId: Int,
    val stickerId: Int,
    val isAllowed: Boolean,
    val animationUrl: String
)

data class Photo(
    val id: Int,
    val albumId: Int,
    val text: String,
    val width: Int,
    val height: Int

)
