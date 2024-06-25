fun main() {
    val attachments = listOf(
        PhotoAttachment(1, 1, "https://vk.com/some_photo_link", "https://vk.com/another_photo_link"),
        VideoAttachment(1, 1, "A Funny Video", 30)
    )

    val post = Post(1, 1, 1, null, 1234567890, "Hello, world!", Likes(), Comments(), Reposts(), Views(), attachments.toTypedArray())
    println(post)
}

interface Attachment {
    val type: String
}

abstract class MediaAttachment(override val type: String) : Attachment {
    abstract val id: Int
    abstract val ownerId: Int
}

class PhotoAttachment(
    override val id: Int,
    override val ownerId: Int,
    val photo130: String,
    val photo604: String
) : MediaAttachment("photo")

class VideoAttachment(
    override val id: Int,
    override val ownerId: Int,
    val title: String,
    val duration: Int
) : MediaAttachment("video")

class AudioAttachment(
    override val id: Int,
    override val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int
) : MediaAttachment("audio")

class DocumentAttachment(
    override val id: Int,
    override val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String
) : MediaAttachment("doc")

class LinkAttachment(
    val url: String,
    val title: String,
    val description: String
) : Attachment {
    override val type: String = "link"
}

class Likes {
    // Implementation details of Likes class
}

class Comments {
    // Implementation details of Comments class
}

class Reposts {
    // Implementation details of Reposts class
}

class Views {
    // Implementation details of Views class
}

class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int?,
    val date: Int,
    val text: String,
    val likes: Likes = Likes(),
    val comments: Comments = Comments(),
    val reposts: Reposts = Reposts(),
    val views: Views = Views(),
    val attachments: Array<Attachment> = emptyArray()
) {
    fun addAttachment(attachment: Attachment) {
        attachments.plus(attachment)
    }
}