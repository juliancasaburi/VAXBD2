use vaccination;
db.nurses.find( { experience: { $lte: 5} })