import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable

@Introspected
@Serdeable
data class PageResponse<T>(
    @JsonProperty("content") val content: List<T>,
    @JsonProperty("pageable") val pageable: Pageable,
    @JsonProperty("last") val last: Boolean,
    @JsonProperty("totalPages") val totalPages: Int,
    @JsonProperty("totalElements") val totalElements: Long,
    @JsonProperty("size") val size: Int,
    @JsonProperty("number") val number: Int,
    @JsonProperty("sort") val sort: Sort,
    @JsonProperty("first") val first: Boolean,
    @JsonProperty("numberOfElements") val numberOfElements: Int,
    @JsonProperty("empty") val empty: Boolean
)
@Serdeable
@Introspected
data class Pageable(
    val pageNumber: Int,
    val pageSize: Int,
    val sort: Sort,
    val offset: Int,
    val paged: Boolean,
    val unpaged: Boolean
)

@Introspected
@Serdeable
data class Sort(
    val empty: Boolean,
    val sorted: Boolean,
    val unsorted: Boolean
)