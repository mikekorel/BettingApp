package com.mikekorel.domain.model

import com.mikekorel.network.model.SportEventApiModel
import junit.framework.TestCase.assertEquals
import org.junit.Test

class DomainModelTransformersTest {

    @Test
    fun sportEventName_isSplitToTwo_whenFormattedAsExpected() {
        val apiModel = SportEventApiModel(
            name = "Team 1 - Team 2"
        )
        val domainModel = apiModel.toDomainModel()

        assertEquals(domainModel.firstTeamName, "Team 1")
        assertEquals(domainModel.secondTeamName, "Team 2")
    }

    @Test
    fun sportEventName_isSplitToTwo_whenDashInATeamsName() {
        val apiModel = SportEventApiModel(
            name = "Team-1 - Team 2"
        )
        val domainModel = apiModel.toDomainModel()

        assertEquals("Team-1", domainModel.firstTeamName)
        assertEquals("Team 2", domainModel.secondTeamName)
    }

}