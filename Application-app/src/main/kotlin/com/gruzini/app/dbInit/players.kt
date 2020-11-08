package com.gruzini.app.dbInit

import com.gruzini.data.Players
import com.gruzini.models.Position
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction


fun players(db: Database) {
    lakers(db)
}

private fun lakers(db: Database){
    transaction(db) {
        Players.insert {
            it[id] = 1
            it[firstName] = "Kobe"
            it[surname] = "Bryant"
            it[number] = 24
            it[position] = Position.SHOOTING_GUARD
            it[height] = 198
            it[weight] = 93
            it[age] = 41
            it[careerLength] = 20
            it[teamId] = 1
        }
        Players.insert {
            it[id] = 2
            it[firstName] = "Wilt"
            it[surname] = "Chamberlain"
            it[number] = 13
            it[position] = Position.CENTER
            it[height] = 216
            it[weight] = 124
            it[age] = 63
            it[careerLength] = 14
            it[teamId] = 1
        }
        Players.insert {
            it[id] = 3
            it[firstName] = "Jim"
            it[surname] = "Pollard"
            it[number] = 17
            it[position] = Position.SMALL_FORWARD
            it[height] = 193
            it[weight] = 83
            it[age] = 70
            it[careerLength] = 7
            it[teamId] = 1
        }
        Players.insert {
            it[id] = 4
            it[firstName] = "Vern"
            it[surname] = "Mikkelsen"
            it[number] = 19
            it[position] = Position.POWER_FORWARD
            it[height] = 201
            it[weight] = 104
            it[age] = 85
            it[careerLength] = 10
            it[teamId] = 1
        }
        Players.insert {
            it[id] = 5
            it[firstName] = "Elgin"
            it[surname] = "Baylor"
            it[number] = 22
            it[position] = Position.SMALL_FORWARD
            it[height] = 196
            it[weight] = 102
            it[age] = 86
            it[careerLength] = 14
            it[teamId] = 1
        }
        Players.insert {
            it[id] = 6
            it[firstName] = "Slater"
            it[surname] = "Martin"
            it[number] = 22
            it[position] = Position.POINT_GUARD
            it[height] = 178
            it[weight] = 77
            it[age] = 86
            it[careerLength] = 13
            it[teamId] = 1
        }
        Players.insert {
            it[id] = 7
            it[firstName] = "Gail"
            it[surname] = "Goodrich"
            it[number] = 25
            it[position] = Position.SHOOTING_GUARD
            it[height] = 185
            it[weight] = 77
            it[age] = 77
            it[careerLength] = 14
            it[teamId] = 1
        }
        Players.insert {
            it[id] = 8
            it[firstName] = "Ervin Magic"
            it[surname] = "Johnson"
            it[number] = 32
            it[position] = Position.POINT_GUARD
            it[height] = 205
            it[weight] = 97
            it[age] = 61
            it[careerLength] = 13
            it[teamId] = 1
        }
        Players.insert {
            it[id] = 9
            it[firstName] = "Kareem Abdul"
            it[surname] = "Jabbar"
            it[number] = 33
            it[position] = Position.CENTER
            it[height] = 218
            it[weight] = 102
            it[age] = 73
            it[careerLength] = 20
            it[teamId] = 1
        }
        Players.insert {
            it[id] = 10
            it[firstName] = "Clyde"
            it[surname] = "Lovellette"
            it[number] = 34
            it[position] = Position.CENTER
            it[height] = 206
            it[weight] = 106
            it[age] = 86
            it[careerLength] = 11
            it[teamId] = 1
        }
        Players.insert {
            it[id] = 11
            it[firstName] = "Shaquille"
            it[surname] = "O'Neal"
            it[number] = 34
            it[position] = Position.CENTER
            it[height] = 216
            it[weight] = 147
            it[age] = 48
            it[careerLength] = 19
            it[teamId] = 1
        }
        Players.insert {
            it[id] = 12
            it[firstName] = "James"
            it[surname] = "Worthy"
            it[number] = 42
            it[position] = Position.POWER_FORWARD
            it[height] = 206
            it[weight] = 102
            it[age] = 59
            it[careerLength] = 12
            it[teamId] = 1
        }
        Players.insert {
            it[id] = 13
            it[firstName] = "Jerry"
            it[surname] = "West"
            it[number] = 44
            it[position] = Position.POINT_GUARD
            it[height] = 188
            it[weight] = 79
            it[age] = 82
            it[careerLength] = 14
            it[teamId] = 1
        }
        Players.insert {
            it[id] = 14
            it[firstName] = "Jamaal"
            it[surname] = "Wilkes"
            it[number] = 52
            it[position] = Position.SMALL_FORWARD
            it[height] = 198
            it[weight] = 86
            it[age] = 67
            it[careerLength] = 12
            it[teamId] = 1
        }
        Players.insert {
            it[id] = 15
            it[firstName] = "George"
            it[surname] = "Mikan"
            it[number] = 99
            it[position] = Position.CENTER
            it[height] = 208
            it[weight] = 111
            it[age] = 80
            it[careerLength] = 7
            it[teamId] = 1
        }
    }
}