use vaccination;
db.nurses.find( { $and: [ { experience: { $gte: 6} }, { vaccines: "Moderna" } ] } )