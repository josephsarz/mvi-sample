package com.example.android.mvisample.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class EventsResponse(@SerializedName("meta") @Expose var meta: Meta,
                          @SerializedName("in_hand") @Expose var inHand: InHand,
                          @SerializedName("events") @Expose var events: List<Event>)


data class Meta(@SerializedName("geolocation") @Expose var geolocation: Any,
                @SerializedName("per_page") @Expose var perPage: Int,
                @SerializedName("total") @Expose var total: Int,
                @SerializedName("took") @Expose var took: Int,
                @SerializedName("page") @Expose var page: Int)

class InHand

data class Event(@SerializedName("datetime_utc") @Expose var datetimeUtc: String,
                 @SerializedName("datetime_tbd") @Expose var datetimeTbd: Boolean,
                 @SerializedName("taxonomies") @Expose var taxonomies: List<Taxonomy>,
                 @SerializedName("type") @Expose var type: String,
                 @SerializedName("id") @Expose var id: Int,
                 @SerializedName("popularity") @Expose var popularity: Double,
                 @SerializedName("date_tbd") @Expose var dateTbd: Boolean,
                 @SerializedName("time_tbd") @Expose var timeTbd: Boolean,
                 @SerializedName("stats") @Expose var stats: Stats,
                 @SerializedName("links") @Expose var links: List<Any>,
                 @SerializedName("title") @Expose var title: String,
                 @SerializedName("short_title") @Expose var shortTitle: String,
                 @SerializedName("score") @Expose var score: Double,
                 @SerializedName("is_open") @Expose var isOpen: Boolean,
                 @SerializedName("visible_until_utc") @Expose var visibleUntilUtc: String,
                 @SerializedName("status") @Expose var status: String,
                 @SerializedName("datetime_local") @Expose var datetimeLocal: String,
                 @SerializedName("created_at") @Expose var createdAt: String,
                 @SerializedName("announce_date") @Expose var announceDate: String,
                 @SerializedName("performers") @Expose var performers: List<Performer>,
                 @SerializedName("url") @Expose var url: String,
                 @SerializedName("venue") @Expose var venue: Venue,
                 @SerializedName("general_admission") @Expose var generalAdmission: Boolean)


data class Performer(@SerializedName("colors") @Expose var colors: Any,
                     @SerializedName("taxonomies")
                     @Expose
                     var taxonomies: List<Taxonomy_>,
                     @SerializedName("type")
                     @Expose
                     var type: String,
                     @SerializedName("slug")
                     @Expose
                     var slug: String,
                     @SerializedName("divisions")
                     @Expose
                     var divisions: Any,
                     @SerializedName("popularity")
                     @Expose
                     var popularity: Double,
                     @SerializedName("home_venue_id")
                     @Expose
                     var homeVenueId: Any,
                     @SerializedName("images")
                     @Expose
                     var images: Images,
                     @SerializedName("stats")
                     @Expose
                     var stats: Stats_,
                     @SerializedName("score")
                     @Expose
                     var score: Double,
                     @SerializedName("has_upcoming_events")
                     @Expose
                     var hasUpcomingEvents: Boolean,
                     @SerializedName("id")
                     @Expose
                     var id: Int,
                     @SerializedName("genres")
                     @Expose
                     var genres: List<Genre>,
                     @SerializedName("name")
                     @Expose
                     var name: String,
                     @SerializedName("image_attribution")
                     @Expose
                     var imageAttribution: Any,
                     @SerializedName("num_upcoming_events")
                     @Expose
                     var numUpcomingEvents: Int,
                     @SerializedName("short_name")
                     @Expose
                     var shortName: String,
                     @SerializedName("url")
                     @Expose
                     var url: String,
                     @SerializedName("image")
                     @Expose
                     var image: Any,
                     @SerializedName("image_license")
                     @Expose
                     var imageLicense: Any,
                     @SerializedName("primary")
                     @Expose
                     var primary: Boolean,
                     @SerializedName("away_team")
                     @Expose
                     var awayTeam: Boolean,
                     @SerializedName("home_team")
                     @Expose
                     var homeTeam: Boolean)


data class Venue(@SerializedName("location") @Expose var location: Location,
                 @SerializedName("timezone") @Expose var timezone: String,
                 @SerializedName("id") @Expose var id: Int,
                 @SerializedName("extended_address") @Expose var extendedAddress: String,
                 @SerializedName("popularity") @Expose var popularity: Double,
                 @SerializedName("display_location") @Expose var displayLocation: String,
                 @SerializedName("state") @Expose var state: String,
                 @SerializedName("name_v2") @Expose var nameV2: String,
                 @SerializedName("links") @Expose var links: List<Any>,
                 @SerializedName("score") @Expose var score: Double,
                 @SerializedName("address") @Expose var address: String,
                 @SerializedName("has_upcoming_events") @Expose var hasUpcomingEvents: Boolean,
                 @SerializedName("slug") @Expose var slug: String,
                 @SerializedName("city") @Expose var city: String,
                 @SerializedName("name") @Expose var name: String,
                 @SerializedName("postal_code") @Expose var postalCode: String,
                 @SerializedName("num_upcoming_events") @Expose var numUpcomingEvents: Int,
                 @SerializedName("url") @Expose var url: String,
                 @SerializedName("country") @Expose var country: String)


data class Location(
        @SerializedName("lat")
        @Expose
        var lat: Double,
        @SerializedName("lon")
        @Expose
        var lon: Double)

data class Stats(
        @SerializedName("listing_count")
        @Expose
        var listingCount: Any,
        @SerializedName("average_price")
        @Expose
        var averagePrice: Any,
        @SerializedName("lowest_price_good_deals")
        @Expose
        var lowestPriceGoodDeals: Any,
        @SerializedName("lowest_price")
        @Expose
        var lowestPrice: Any,
        @SerializedName("highest_price")
        @Expose
        var highestPrice: Any)

data class Stats_(
        @SerializedName("event_count")
        @Expose
        var eventCount: Int)


data class Taxonomy(
        @SerializedName("parent_id")
        @Expose
        var parentId: Any,
        @SerializedName("id")
        @Expose
        var id: Int,
        @SerializedName("name")
        @Expose
        var name: String)

data class Taxonomy_(
        @SerializedName("parent_id")
        @Expose
        var parentId: Any,
        @SerializedName("id")
        @Expose
        var id: Int,
        @SerializedName("name")
        @Expose
        var name: String,
        @SerializedName("document_source")
        @Expose
        var documentSource: DocumentSource)


data class DocumentSource(
        @SerializedName("source_type")
        @Expose
        var sourceType: String,
        @SerializedName("generation_type")
        @Expose
        var generationType: String)

data class DocumentSource_(
        @SerializedName("source_type")
        @Expose
        var sourceType: String,
        @SerializedName("generation_type")
        @Expose
        var generationType: String)


data class Genre(
        @SerializedName("images")
        @Expose
        var images: Images_,
        @SerializedName("slug")
        @Expose
        var slug: String,
        @SerializedName("id")
        @Expose
        var id: Int,
        @SerializedName("document_source") @Expose var documentSource: DocumentSource_,
        @SerializedName("name") @Expose var name: String,
        @SerializedName("image") @Expose var image: String,
        @SerializedName("primary") @Expose var primary: Boolean)


data class Images (
    @SerializedName("huge")
    @Expose
    var huge: String)

data class Images_(@SerializedName("criteo_205_100") @Expose var criteo205100: String,
                   @SerializedName("1200x627") @Expose var _1200x627: String,
                   @SerializedName("square_mid") @Expose var squareMid: String,
                   @SerializedName("ipad_event_modal") @Expose var ipadEventModal: String,
                   @SerializedName("136x136") @Expose var _136x136: String,
                   @SerializedName("banner") @Expose var banner: String,
                   @SerializedName("triggit_fb_ad") @Expose var triggitFbAd: String,
                   @SerializedName("ipad_header") @Expose var ipadHeader: String,
                   @SerializedName("500_700") @Expose var _500700: String,
                   @SerializedName("huge") @Expose var huge: String,
                   @SerializedName("fb_100x72") @Expose var fb100x72: String,
                   @SerializedName("criteo_130_160") @Expose var criteo130160: String,
                   @SerializedName("criteo_170_235") @Expose var criteo170235: String,
                   @SerializedName("mongo") @Expose var mongo: String,
                   @SerializedName("800x320") @Expose var _800x320: String,
                   @SerializedName("fb_600_315") @Expose var fb600315: String,
                   @SerializedName("ipad_mini_explore") @Expose var ipadMiniExplore: String,
                   @SerializedName("block") @Expose var block: String,
                   @SerializedName("criteo_400_300") @Expose var criteo400300: String,
                   @SerializedName("1200x525") @Expose var _1200x525: String)