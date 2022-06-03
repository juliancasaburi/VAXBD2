use vaccination;
db.patients.aggregate([
   {
     $geoNear: {
        near: { type: "MultiPolygon", coordinates: [-58.4586,-34.5968] },
        distanceField: "distance.meters",
        maxDistance: 1000,
        spherical: true,
     }
    },   
    { $out : "cabaPatients" }   
])