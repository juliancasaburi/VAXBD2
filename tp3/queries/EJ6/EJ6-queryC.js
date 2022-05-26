use vaccination;
db.nurses.find( { vaccines: { $exists: false } } )