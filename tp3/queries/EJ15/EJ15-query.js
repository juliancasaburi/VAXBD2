use vaccination;
db.patients.aggregate([
   {
     $geoNear: {
        near: { type: "Point", coordinates: [-58.4586,-34.5968] },
        distanceField: "distance.meters",
        maxDistance: 1000,
        spherical: true,
     }
    },   
    { $project: {"distance": 0}},
    { $out : "cabaPatients" }   
])