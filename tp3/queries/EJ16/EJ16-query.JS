use vaccination;
db.doses.aggregate([{
   $lookup:
     {
       from: "cabaPatients",
       localField: "patient",
       foreignField: "name",
       as: "patient"
     },
    },
    { 
      $match : { 
          "patient" : { $ne : []}
      }
}]);