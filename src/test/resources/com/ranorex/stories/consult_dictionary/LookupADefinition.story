Lookup a working with ranorex table

Narrative:
In order to manage persons
As an user
I want to add and delete person to the base

Scenario: Looking up the person Anna Peko
Given the user is on the ranorex home page
When the user looks up the definition of firstName 'Anna' and lastName 'Pedko'
Then they should see the definition firstName 'Anna',lastName 'Pedko',category 'Other',gender 'Female'

Scenario: Looking up the person Maria Tester  Music
Given the user is on the ranorex home page
When the user looks up the definition of firstName 'Maria',lastName 'Tester',category 'Music'
Then they should see the definition firstName 'Maria',lastName 'Tester',category 'Music',gender 'Female'

Scenario: Removing  the person Maria Tester  Music Female
When the user looks up the removing of firstName 'Maria',lastName 'Tester',category 'Music',gender 'Female'
Then they should see the deleted firstName 'Maria',lastName 'Tester',category 'Music',gender 'Female'