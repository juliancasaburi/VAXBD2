use vaccination;
db.nurses.find( { name: { $regex: '\s*Fernández' } } )