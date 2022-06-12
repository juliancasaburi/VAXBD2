use vaccination;
db.nurses.updateMany( { vaccines: "Pfizer" }, {  $mul: { experience: 2 } } )