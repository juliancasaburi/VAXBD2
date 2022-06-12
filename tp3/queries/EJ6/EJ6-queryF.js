use vaccination;
db.nurses.find( { $and: [ { experience: { $gte: 6} }, { vaccines: "Moderna" } ] }, {name:1, _id:0} )