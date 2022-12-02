package dev.imanity.bbbapi.request

import dev.imanity.bbbapi.BBBClient
import dev.imanity.bbbapi.exception.RequestErrorException
import dev.imanity.bbbapi.exception.RequestRateLimitedException
import dev.imanity.bbbapi.exception.RequestThrowsException
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.impl.HealthRequest
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

suspend fun BBBClient.healthReport(wait: Boolean = true) = handle(this.execute(HealthRequest(), wait))

suspend fun BBBClient.listUnreadAlerts(sortOptions: SortOptions = SortOptions.DEFAULT, wait: Boolean = true) = get(this.execute(ListUnreadAlertsRequest(sortOptions), wait))

suspend fun BBBClient.markUnreadAlertsAsRead(read: Boolean = true, wait: Boolean = true) = handle(this.execute(MarkUnreadAlertsAsReadRequest(read), wait))

suspend fun BBBClient.listUnreadConversations(sortOptions: SortOptions = SortOptions.DEFAULT, wait: Boolean = true) = get(this.execute(
    ListUnreadConversationsRequest(sortOptions), wait
))

suspend fun BBBClient.startConversation(userIds: Array<Int>, title: String, message: String, wait: Boolean = true) = get(this.execute(
    StartConversationRequest(userIds, title, message), wait
))

suspend fun BBBClient.listUnreadConversationReplies(conversationId: Int, sortOptions: SortOptions = SortOptions.DEFAULT, wait: Boolean = true) = get(this.execute(
    ListUnreadConversationRepliesRequest(conversationId, sortOptions), wait
))

suspend fun BBBClient.replyToUnreadConversation(conversationId: Int, message: String, wait: Boolean = true) = get(this.execute(
    ReplyToUnreadConversationRequest(conversationId, message), wait
))

suspend fun BBBClient.listBans(wait: Boolean = true) = get(this.execute(ListBansRequest(), wait))

suspend fun BBBClient.modifyYourself(customTitle: String, aboutMe: String, signature: String, wait: Boolean = true) = handle(this.execute(
    ModifyYourselfRequest(customTitle, aboutMe, signature), wait
))

suspend fun BBBClient.retrieveMemberByDiscordID(discordId: Long, wait: Boolean = true) = get(this.execute(RetrieveMemberByDiscordIDRequest(discordId), wait))

suspend fun BBBClient.retrieveMemberById(id: Int, wait: Boolean = true) = get(this.execute(RetrieveMemberByIDRequest(id), wait))

suspend fun BBBClient.retrieveMemberByUsername(username: String, wait: Boolean = true) = get(this.execute(RetrieveMemberByUsernameRequest(username), wait))

suspend fun BBBClient.retrieveYourself(wait: Boolean = true) = get(this.execute(RetrieveYourselfRequest(), wait))

suspend fun BBBClient.deleteProfilePost(postId: Int, wait: Boolean = true) = handle(this.execute(DeleteProfilePostRequest(postId), wait))

suspend fun BBBClient.editProfilePost(postId: Int, message: String, wait: Boolean = true) = handle(this.execute(EditProfilePostRequest(postId, message), wait))

suspend fun BBBClient.listProfilePosts(sortOptions: SortOptions = SortOptions.DEFAULT, wait: Boolean = true) = get(this.execute(ListProfilePostsRequest(sortOptions), wait))

suspend fun BBBClient.retrieveProfilePost(postId: Int, wait: Boolean = true) = get(this.execute(RetrieveProfilePostRequest(postId), wait))

suspend fun BBBClient.listCollaboratedResources(sortOptions: SortOptions = SortOptions.DEFAULT, wait: Boolean = true) = get(this.execute(
    ListCollaboratedResourcesRequest(sortOptions), wait
))

suspend fun BBBClient.listOwnedResources(sortOptions: SortOptions = SortOptions.DEFAULT, wait: Boolean = true) = get(this.execute(ListOwnedResourcesRequest(sortOptions), wait))

suspend fun BBBClient.listPublicResources(sortOptions: SortOptions = SortOptions.DEFAULT, wait: Boolean = true) = get(this.execute(ListPublicResourcesRequest(sortOptions), wait))

suspend fun BBBClient.listResourcesByAuthor(authorId: Int, sortOptions: SortOptions = SortOptions.DEFAULT, wait: Boolean = true) = get(this.execute(
    ListResourcesByAuthorRequest(authorId, sortOptions), wait
))

suspend fun BBBClient.modifyResource(resourceId: Int, title: String, tagline: String, description: String, wait: Boolean = true) = handle(this.execute(
    ModifyResourceRequest(resourceId, title, tagline, description), wait
))

suspend fun BBBClient.retrieveResourceById(resourceId: Int, wait: Boolean = true) = get(this.execute(RetrieveResourceRequest(resourceId), wait))

suspend fun BBBClient.listResourceDownloadsByMember(resourceId: Int, memberId: Int, sortOptions: SortOptions = SortOptions.DEFAULT, wait: Boolean = true) = get(this.execute(
    ListResourceDownloadsByMemberRequest(resourceId, memberId, sortOptions), wait
))

suspend fun BBBClient.listResourceDownloadsByVersion(resourceId: Int, versionId: Int, sortOptions: SortOptions = SortOptions.DEFAULT, wait: Boolean = true) = get(this.execute(
    ListResourceDownloadsByVersionRequest(resourceId, versionId, sortOptions), wait
))

suspend fun BBBClient.listResourceDownloads(resourceId: Int, sortOptions: SortOptions = SortOptions.DEFAULT, wait: Boolean = true) = get(this.execute(
    ListResourceDownloadsRequest(resourceId, sortOptions), wait
))

suspend fun BBBClient.listResourceLicenses(resourceId: Int, sortOptions: SortOptions = SortOptions.DEFAULT, wait: Boolean = true) = get(this.execute(
    ListResourceLicensesRequest(resourceId, sortOptions), wait
))

suspend fun BBBClient.modifyResourceLicense(resourceId: Int, licenseId: Int, permenant: Boolean, active: Boolean, startDate: Long, endDate: Long, wait: Boolean = true) = handle(this.execute(
    ModifyResourceLicenseRequest(resourceId, licenseId, permenant, active, startDate, endDate), wait
))

suspend fun BBBClient.retrieveResourceLicenseByMember(resourceId: Int, memberId: Int, nonce: Int, timestamp: Long, wait: Boolean = true) = get(this.execute(
    RetrieveResourceLicenseByMemberRequest(resourceId, memberId, nonce, timestamp), wait
))

suspend fun BBBClient.retrieveResourceLicense(resourceId: Int, licenseId: Int, wait: Boolean = true) = get(this.execute(
    RetrieveResourceLicenseRequest(resourceId, licenseId), wait
))

suspend fun BBBClient.listResourcePurchases(resourceId: Int, sortOptions: SortOptions = SortOptions.DEFAULT, wait: Boolean = true) = get(this.execute(
    ListResourcePurchasesRequest(resourceId, sortOptions), wait
))

suspend fun BBBClient.retrieveResourcePurchase(resourceId: Int, purchaseId: Int, wait: Boolean = true) = get(this.execute(
    RetrieveResourcePurchaseRequest(resourceId, purchaseId), wait
))

suspend fun BBBClient.listResourceReviews(resourceId: Int, sortOptions: SortOptions = SortOptions.DEFAULT, wait: Boolean = true) = get(this.execute(
    ListResourceReviewsRequest(resourceId, sortOptions), wait
))

suspend fun BBBClient.respondToResourceReview(resourceId: Int, reviewId: Int, message: String, wait: Boolean = true) = handle(this.execute(
    RespondToResourceReviewRequest(resourceId, reviewId, message), wait
))

suspend fun BBBClient.retrieveMemberResourceReview(resourceId: Int, memberId: Int, wait: Boolean = true) = get(this.execute(
    RetrieveMemberResourceReviewRequest(resourceId, memberId), wait
))

suspend fun BBBClient.listResourceUpdates(resourceId: Int, sortOptions: SortOptions = SortOptions.DEFAULT, wait: Boolean = true) = get(this.execute(
    ListResourceUpdatesRequest(resourceId, sortOptions), wait
))

suspend fun BBBClient.retrieveLatestResourceUpdate(resourceId: Int, wait: Boolean = true) = get(this.execute(
    RetrieveLatestResourceUpdateRequest(resourceId), wait
))

suspend fun BBBClient.retrieveResourceUpdate(resourceId: Int, updateId: Int, wait: Boolean = true) = get(this.execute(
    RetrieveResourceUpdateRequest(resourceId, updateId), wait
))

suspend fun BBBClient.listResourceVersions(resourceId: Int, sortOptions: SortOptions = SortOptions.DEFAULT, wait: Boolean = true) = get(this.execute(
    ListResourceVersionsRequest(resourceId, sortOptions), wait
))

suspend fun BBBClient.retrieveLatestResourceVersion(resourceId: Int, wait: Boolean = true) = get(this.execute(
    RetrieveLatestResourceVersionRequest(resourceId), wait
))

suspend fun BBBClient.retrieveResourceVersion(resourceId: Int, versionId: Int, wait: Boolean = true) = get(this.execute(
    RetrieveResourceVersionRequest(resourceId, versionId), wait
))

suspend fun BBBClient.retrieveThread(threadId: Int, wait: Boolean = true) = get(this.execute(RetrieveThreadRequest(threadId), wait))

suspend fun BBBClient.listThreads(sortOptions: SortOptions = SortOptions.DEFAULT, wait: Boolean = true) = get(this.execute(ListThreadsRequest(sortOptions), wait))

suspend fun BBBClient.listThreadReplies(threadId: Int, sortOptions: SortOptions = SortOptions.DEFAULT, wait: Boolean = true) = get(this.execute(
    ListThreadRepliesRequest(threadId, sortOptions), wait
))

suspend fun BBBClient.replyToThread(threadId: Int, message: String, wait: Boolean = true) = handle(this.execute(ReplyToThreadRequest(threadId, message), wait))

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