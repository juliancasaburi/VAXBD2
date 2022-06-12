var vaccines = ['AZ', 'Pfizer', 'Moderna', 'Sputnik V', "Johnson"];

for (var i = 1; i <= 2000; i++) {

	var randomVax = vaccines.sort(function () { return 0.5 - Math.random() }).slice(1, Math.floor(Math.random() * 5));
	var randomExperience = Math.ceil(2 + (Math.random() * 20 - 2));

	db.nurses.insert({
		name: 'Enfermero ' + i,
		experience: randomExperience,
		tags: randomVax
	});
}

var patientNumber = 0;

for (var i = 1; i <= 2000; i++) {

	var dosesCount = 50 + Math.ceil(Math.random() * 100);

	for (var r = 1; r <= dosesCount; r++) {

		var randomLong = -34.56 - (Math.random() * .23);
		var randomLat = -58.4 - (Math.random() * .22);

		db.patients.insert({
			name: 'Paciente ' + patientNumber,
			address: { type: "Point", coordinates: [randomLat, randomLong] }
		});

		patientNumber++;

		var year = 2020 + Math.round(Math.random());
		var month = Math.ceil(Math.random() * 12);
		var day = Math.ceil(Math.random() * 28);

		db.doses.insert({
			nurse: 'Enfermero ' + i,
			patient: 'Paciente ' + patientNumber,
			vaccine: vaccines[Math.floor(Math.random() * vaccines.length)],
			date: new Date(year + '-' + month + '-' + day)
		});
	}

}
