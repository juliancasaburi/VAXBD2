use vaccination;
db.nurses.find( { experience: { $lt: 5} })