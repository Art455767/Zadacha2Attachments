fun main() {
    val attachments = listOf(
        Photo(1, 1, "https://vk.com/some_photo_link", "https://vk.com/another_photo_link"),
        Video(1, 1, "A Funny Video", 30)
    )

    val post = Post(1, 1, 1, null, 1234567890, "Hello, world!", Likes(), Comments(), Reposts(), Views(), attachments.toTypedArray())
    println(post)
}


interface Attachment {
    val type: String
}


abstract class PhotoAttachment(override val type: String) : Attachment {
    abstract val id: Int
    abstract val ownerId: Int
}


class Photo(
    override val id: Int,
    override val ownerId: Int,
    val photo130: String,
    val photo604: String
) : PhotoAttachment("photo")


class Video(
    override val id: Int,
    override val ownerId: Int,
    val title: String,
    val duration: Int
) : PhotoAttachment("video")


class Audio(
    override val id: Int,
    override val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int
) : PhotoAttachment("audio")


class Document(
    override val id: Int,
    override val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String
) : PhotoAttachment("doc")

class Likes {

}

class Comments {

}

class Reposts {

}

class Views {

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
