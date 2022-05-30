use vaccination;
db.doses.find({nurse: /11/}).explain("executionStats")
