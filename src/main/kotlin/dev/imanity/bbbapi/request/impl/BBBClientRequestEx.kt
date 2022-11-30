package dev.imanity.bbbapi.request.impl

import dev.imanity.bbbapi.BBBClient
import dev.imanity.bbbapi.exception.RequestErrorException
import dev.imanity.bbbapi.exception.RequestRateLimitedException
import dev.imanity.bbbapi.exception.RequestThrowsException
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Response
import dev.imanity.bbbapi.request.Type
import dev.imanity.bbbapi.request.impl.alert.ListUnreadAlertsRequest
import dev.imanity.bbbapi.request.impl.alert.MarkUnreadAlertsAsReadRequest
import dev.imanity.bbbapi.request.impl.conversation.ListUnreadConversationsRequest
import dev.imanity.bbbapi.request.impl.conversation.StartConversationRequest
import dev.imanity.bbbapi.request.impl.conversation.reply.ListUnreadConversationRepliesRequest
import dev.imanity.bbbapi.request.impl.conversation.reply.ReplyToUnreadConversationRequest
import dev.imanity.bbbapi.request.impl.member.*
import dev.imanity.bbbapi.request.impl.member.post.DeleteProfilePostRequest
import dev.imanity.bbbapi.request.impl.member.post.EditProfilePostRequest
import dev.imanity.bbbapi.request.impl.member.post.ListProfilePostsRequest
import dev.imanity.bbbapi.request.impl.member.post.RetrieveProfilePostRequest
import dev.imanity.bbbapi.request.impl.resource.*
import dev.imanity.bbbapi.request.impl.resource.download.ListResourceDownloadsByMemberRequest
import dev.imanity.bbbapi.request.impl.resource.download.ListResourceDownloadsByVersionRequest
import dev.imanity.bbbapi.request.impl.resource.download.ListResourceDownloadsRequest
import dev.imanity.bbbapi.request.impl.resource.license.ListResourceLicensesRequest
import dev.imanity.bbbapi.request.impl.resource.license.ModifyResourceLicenseRequest
import dev.imanity.bbbapi.request.impl.resource.license.RetrieveResourceLicenseByMemberRequest
import dev.imanity.bbbapi.request.impl.resource.license.RetrieveResourceLicenseRequest
import dev.imanity.bbbapi.request.impl.resource.purchase.ListResourcePurchasesRequest
import dev.imanity.bbbapi.request.impl.resource.purchase.RetrieveResourcePurchaseRequest
import dev.imanity.bbbapi.request.impl.resource.review.ListResourceReviewsRequest
import dev.imanity.bbbapi.request.impl.resource.review.RespondToResourceReviewRequest
import dev.imanity.bbbapi.request.impl.resource.review.RetrieveMemberResourceReviewRequest
import dev.imanity.bbbapi.request.impl.resource.update.ListResourceUpdatesRequest
import dev.imanity.bbbapi.request.impl.resource.update.RetrieveLatestResourceUpdateRequest
import dev.imanity.bbbapi.request.impl.resource.update.RetrieveResourceUpdateRequest
import dev.imanity.bbbapi.request.impl.resource.version.ListResourceVersionsRequest
import dev.imanity.bbbapi.request.impl.resource.version.RetrieveLatestResourceVersionRequest
import dev.imanity.bbbapi.request.impl.resource.version.RetrieveResourceVersionRequest
import dev.imanity.bbbapi.request.impl.thread.RetrieveThreadRequest
import dev.imanity.bbbapi.request.impl.thread.ListThreadsRequest
import dev.imanity.bbbapi.request.impl.thread.reply.ListThreadRepliesRequest
import dev.imanity.bbbapi.request.impl.thread.reply.ReplyToThreadRequest

suspend fun BBBClient.healthReport() = handle(this.execute(HealthRequest()))

suspend fun BBBClient.listUnreadAlerts(sortOptions: SortOptions = SortOptions.DEFAULT) = get(this.execute(ListUnreadAlertsRequest(sortOptions)))

suspend fun BBBClient.markUnreadAlertsAsRead(read: Boolean = true) = handle(this.execute(MarkUnreadAlertsAsReadRequest(read)))

suspend fun BBBClient.listUnreadConversations(sortOptions: SortOptions = SortOptions.DEFAULT) = get(this.execute(
    ListUnreadConversationsRequest(sortOptions)
))

suspend fun BBBClient.startConversation(userIds: Array<Int>, title: String, message: String) = handle(this.execute(
    StartConversationRequest(userIds, title, message)
))

suspend fun BBBClient.listUnreadConversationReplies(conversationId: Int, sortOptions: SortOptions = SortOptions.DEFAULT) = get(this.execute(
    ListUnreadConversationRepliesRequest(conversationId, sortOptions)
))

suspend fun BBBClient.replyToUnreadConversation(conversationId: Int, message: String) = handle(this.execute(
    ReplyToUnreadConversationRequest(conversationId, message)
))

suspend fun BBBClient.listBans() = get(this.execute(ListBansRequest()))

suspend fun BBBClient.modifyYourself(customTitle: String, aboutMe: String, signature: String) = handle(this.execute(
    ModifyYourselfRequest(customTitle, aboutMe, signature)
))

suspend fun BBBClient.retrieveMemberByDiscordID(discordId: Long) = get(this.execute(RetrieveMemberByDiscordIDRequest(discordId)))

suspend fun BBBClient.retrieveMemberById(id: Int) = get(this.execute(RetrieveMemberByIDRequest(id)))

suspend fun BBBClient.retrieveMemberByUsername(username: String) = get(this.execute(RetrieveMemberByUsernameRequest(username)))

suspend fun BBBClient.retrieveYourself() = get(this.execute(RetrieveYourselfRequest()))

suspend fun BBBClient.deleteProfilePost(postId: Int) = handle(this.execute(DeleteProfilePostRequest(postId)))

suspend fun BBBClient.editProfilePost(postId: Int, message: String) = handle(this.execute(EditProfilePostRequest(postId, message)))

suspend fun BBBClient.listProfilePosts(sortOptions: SortOptions) = get(this.execute(ListProfilePostsRequest(sortOptions)))

suspend fun BBBClient.retrieveProfilePost(postId: Int) = get(this.execute(RetrieveProfilePostRequest(postId)))

suspend fun BBBClient.listCollaboratedResources(sortOptions: SortOptions) = get(this.execute(
    ListCollaboratedResourcesRequest(sortOptions)
))

suspend fun BBBClient.listOwnedResources(sortOptions: SortOptions) = get(this.execute(ListOwnedResourcesRequest(sortOptions)))

suspend fun BBBClient.listPublicResources(sortOptions: SortOptions) = get(this.execute(ListPublicResourcesRequest(sortOptions)))

suspend fun BBBClient.listResourcesByAuthor(authorId: Int, sortOptions: SortOptions) = get(this.execute(
    ListResourcesByAuthorRequest(authorId, sortOptions)
))

suspend fun BBBClient.modifyResource(resourceId: Int, title: String, tagline: String, description: String) = handle(this.execute(
    ModifyResourceRequest(resourceId, title, tagline, description)
))

suspend fun BBBClient.retrieveResourceById(resourceId: Int) = get(this.execute(RetrieveResourceRequest(resourceId)))

suspend fun BBBClient.listResourceDownloadsByMember(resourceId: Int, memberId: Int, sortOptions: SortOptions) = get(this.execute(
    ListResourceDownloadsByMemberRequest(resourceId, memberId, sortOptions)
))

suspend fun BBBClient.listResourceDownloadsByVersion(resourceId: Int, versionId: Int, sortOptions: SortOptions) = get(this.execute(
    ListResourceDownloadsByVersionRequest(resourceId, versionId, sortOptions)
))

suspend fun BBBClient.listResourceDownloads(resourceId: Int, sortOptions: SortOptions) = get(this.execute(
    ListResourceDownloadsRequest(resourceId, sortOptions)
))

suspend fun BBBClient.listResourceLicenses(resourceId: Int, sortOptions: SortOptions) = get(this.execute(
    ListResourceLicensesRequest(resourceId, sortOptions)
))

suspend fun BBBClient.modifyResourceLicense(resourceId: Int, licenseId: Int, permenant: Boolean, active: Boolean, startDate: Long, endDate: Long) = handle(this.execute(
    ModifyResourceLicenseRequest(resourceId, licenseId, permenant, active, startDate, endDate)
))

suspend fun BBBClient.retrieveResourceLicenseByMember(resourceId: Int, memberId: Int, nonce: Int, timestamp: Long) = get(this.execute(
    RetrieveResourceLicenseByMemberRequest(resourceId, memberId, nonce, timestamp)
))

suspend fun BBBClient.retrieveResourceLicense(resourceId: Int, licenseId: Int) = get(this.execute(
    RetrieveResourceLicenseRequest(resourceId, licenseId)
))

suspend fun BBBClient.listResourcePurchases(resourceId: Int, sortOptions: SortOptions) = get(this.execute(
    ListResourcePurchasesRequest(resourceId, sortOptions)
))

suspend fun BBBClient.retrieveResourcePurchase(resourceId: Int, purchaseId: Int) = get(this.execute(
    RetrieveResourcePurchaseRequest(resourceId, purchaseId)
))

suspend fun BBBClient.listResourceReviews(resourceId: Int, sortOptions: SortOptions) = get(this.execute(
    ListResourceReviewsRequest(resourceId, sortOptions)
))

suspend fun BBBClient.respondToResourceReview(resourceId: Int, reviewId: Int, message: String) = handle(this.execute(
    RespondToResourceReviewRequest(resourceId, reviewId, message)
))

suspend fun BBBClient.retrieveMemberResourceReview(resourceId: Int, memberId: Int) = get(this.execute(
    RetrieveMemberResourceReviewRequest(resourceId, memberId)
))

suspend fun BBBClient.listResourceUpdates(resourceId: Int, sortOptions: SortOptions) = get(this.execute(
    ListResourceUpdatesRequest(resourceId, sortOptions)
))

suspend fun BBBClient.retrieveLatestResourceUpdate(resourceId: Int) = get(this.execute(
    RetrieveLatestResourceUpdateRequest(resourceId)
))

suspend fun BBBClient.retrieveResourceUpdate(resourceId: Int, updateId: Int) = get(this.execute(
    RetrieveResourceUpdateRequest(resourceId, updateId)
))

suspend fun BBBClient.listResourceVersions(resourceId: Int, sortOptions: SortOptions) = get(this.execute(
    ListResourceVersionsRequest(resourceId, sortOptions)
))

suspend fun BBBClient.retrieveLatestResourceVersion(resourceId: Int) = get(this.execute(
    RetrieveLatestResourceVersionRequest(resourceId)
))

suspend fun BBBClient.retrieveResourceVersion(resourceId: Int, versionId: Int) = get(this.execute(
    RetrieveResourceVersionRequest(resourceId, versionId)
))

suspend fun BBBClient.retrieveThread(threadId: Int) = get(this.execute(RetrieveThreadRequest(threadId)))

suspend fun BBBClient.listThreads(sortOptions: SortOptions) = get(this.execute(ListThreadsRequest(sortOptions)))

suspend fun BBBClient.listThreadReplies(threadId: Int, sortOptions: SortOptions) = get(this.execute(
    ListThreadRepliesRequest(threadId, sortOptions)
))

suspend fun BBBClient.replyToThread(threadId: Int, message: String) = handle(this.execute(ReplyToThreadRequest(threadId, message)))

private fun handle(response: Response<*>) {
    when (response.type) {
        Type.EXCEPTION -> throw RequestThrowsException(response.exception!!)
        Type.ERROR -> throw RequestErrorException(response.error!!)
        Type.RATE_LIMITED -> throw RequestRateLimitedException(response.rateLimitTime)
        else -> Unit
    }
}

private fun <T> get(response: Response<T>): T {
    when (response.type) {
        Type.SUCCESS -> return response.value!!
        Type.EXCEPTION -> throw RequestThrowsException(response.exception!!)
        Type.ERROR -> throw RequestErrorException(response.error!!)
        Type.RATE_LIMITED -> throw RequestRateLimitedException(response.rateLimitTime)
    }
}