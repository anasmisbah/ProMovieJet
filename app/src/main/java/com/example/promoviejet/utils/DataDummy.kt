package com.example.promoviejet.utils

import com.example.promoviejet.R
import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.data.local.entity.TvShow

object DataDummy {
//    fun generateDummyMovie(): ArrayList<Movie>{
//        val movies = ArrayList<Movie>()
//        movies.add(
//            Movie(
//                "movie1",
//                "A Star Is Born",
//                "7.5",
//                "English",
//                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about " +
//                        "given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, " +
//                        "the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
//                "5 october 2018",
//                R.drawable.poster_a_start_is_born
//            )
//        )
//
//        movies.add(
//            Movie(
//                "movie2",
//                "Alita: Battle Angel",
//                "6.6",
//                "English",
//                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this " +
//                        "abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
//                "14 february 2019",
//                R.drawable.poster_alita
//            )
//        )
//        movies.add(
//            Movie(
//                "movie3",
//                "Aquaman",
//                "6.8",
//                "English",
//                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, " +
//                        "Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
//                "21 December 2018",
//                R.drawable.poster_aquaman
//            )
//        )
//        movies.add(
//            Movie(
//                "movie4",
//                "Bohemian Rhapsody",
//                "8.1",
//                "English",
//                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. " +
//                        "Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
//                "30 october 2018",
//                R.drawable.poster_bohemian
//            )
//        )
//        movies.add(
//            Movie(
//                "movie5",
//                "Cold Pursuit",
//                "5.2",
//                "English",
//                "Nels Coxman's quiet life comes crashing down when his beloved son dies under mysterious circumstances. His search for the truth soon becomes a quest for revenge as he seeks coldblooded justice against a drug lord and his inner circle",
//                "8 February 2019",
//                R.drawable.poster_cold_persuit
//            )
//        )
//        movies.add(
//            Movie(
//                "movie6",
//                "Creed II",
//                "6.6",
//                "English",
//                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
//                "14 November 2018",
//                R.drawable.poster_creed
//            )
//        )
//        movies.add(
//            Movie(
//                "movie7",
//                "Fantastic Beasts: The Crimes of Grindelwald",
//                "6.9",
//                "English",
//                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. " +
//                        "The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from " +
//                        "the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as " +
//                        "love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
//                "16 November 2018",
//                R.drawable.poster_crimes
//            )
//        )
//        movies.add(
//            Movie(
//                "movie8",
//                "Glass",
//                "6.5",
//                "English",
//                "In a series of escalating encounters, security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of " +
//                        "Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
//                "18 January 2019",
//                R.drawable.poster_glass
//            )
//        )
//        movies.add(
//            Movie(
//                "movie9",
//                "How to Train Your Dragon: The Hidden World",
//                "7.7",
//                "English",
//                "SAs Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. " +
//                        "When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
//                "22 Februari 2019",
//                R.drawable.poster_how_to_train
//            )
//        )
//        movies.add(
//            Movie(
//                "movie10",
//                "Avengers: Infinity War",
//                "8.3",
//                "English",
//                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to " +
//                        "collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought " +
//                        "for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
//                "23 April 2018",
//                R.drawable.poster_infinity_war
//            )
//        )
//        movies.add(
//            Movie(
//                "movie11",
//                "Mary Queen of Scots",
//                "6.6",
//                "English",
//                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, " +
//                        "rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
//                "15 November 2018",
//                R.drawable.poster_marry_queen
//            )
//        )
//        movies.add(
//            Movie(
//                "movie12",
//                "Master Z: Ip Man Legacy",
//                "5",
//                "Cantonese",
//                "After being defeated by Ip Man, Cheung Tin Chi is attempting to keep a low profile. While going about his business, he gets into a fight with a foreigner by the name of Davidson, " +
//                        "who is a big boss behind the bar district. Tin Chi fights hard with Wing Chun and earns respect.",
//                "12 April 2019",
//                R.drawable.poster_master_z
//            )
//        )
//        movies.add(
//            Movie(
//                "movie13",
//                "Mortal Engines",
//                "6",
//                "English",
//                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter " +
//                        "with a mysterious young woman from the wastelands who will change the course of his life forever.",
//                "14 December 2018",
//                R.drawable.poster_mortal_engines
//            )
//        )
//        movies.add(
//            Movie(
//                "movie14",
//                "Overlord",
//                "6.7",
//                "English",
//                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, " +
//                        "in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
//                "22 September 2018",
//                R.drawable.poster_overlord
//            )
//        )
//        movies.add(
//            Movie(
//                "movie15",
//                "Ralph Breaks the Internet",
//                "7.2",
//                "English",
//                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, \"Sugar Rush.\" In way over their heads, Ralph and Vanellope rely on the citizens of the internet -- the netizens -- to help navigate their way, " +
//                        "including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube",
//                "5 November 2018",
//                R.drawable.poster_ralph
//            )
//        )
//        movies.add(
//            Movie(
//                "movie16",
//                "Robin Hood",
//                "5.7",
//                "English",
//                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown",
//                "21 November 2018",
//                R.drawable.poster_robin_hood
//            )
//        )
//        movies.add(
//            Movie(
//                "movie17",
//                "Serenity",
//                "5",
//                "English",
//                "Baker Dill is a fishing boat captain leading tours off a tranquil, tropical enclave called Plymouth Island. His quiet life is shattered, however, " +
//                        "when his ex-wife Karen tracks him down with a desperate plea for help.",
//                "22 January 2019",
//                R.drawable.poster_serenity
//            )
//        )
//        movies.add(
//            Movie(
//                "movie18",
//                "Spider-Man: Into the Spider-Verse",
//                "8.5",
//                "English",
//                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, " +
//                        "others from across the Spider-Verse are transported to this dimension.",
//                "1 December 2018",
//                R.drawable.poster_spiderman
//            )
//        )
//        movies.add(
//            Movie(
//                "movie19",
//                "T-34",
//                "4.8",
//                "English",
//                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. " +
//                        "Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
//                "27 December 2018",
//                R.drawable.poster_t34
//            )
//        )
//
//        return movies
//    }

//    fun generateDummyTvShow():ArrayList<TvShow>{
//        val tvshows = ArrayList<TvShow>()
//
//        tvshows.add(
//            TvShow(
//                "tvshow1",
//                "Arrow",
//                "5.8",
//                "English",
//                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, " +
//                        "determined to clean up the city as a hooded vigilante armed with a bow.",
//                "10 October 2012",
//                R.drawable.poster_arrow
//            )
//        )
//        tvshows.add(
//            TvShow(
//                "tvshow2",
//                "Doom Patrol",
//                "6",
//                "English",
//                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, " +
//                        "who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
//                "15 December 2019",
//                R.drawable.poster_doom_patrol
//            )
//        )
//        tvshows.add(
//            TvShow(
//                "tvshow3",
//                "Dragon Ball",
//                "7.3",
//                "Japanese",
//                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure that would change Goku's life forever. See how Goku met his life long friends " +
//                        "Bulma, Yamcha, Krillin, Master Roshi and more. And see his adventures as a boy, all leading up to Dragonball Z and later Dragonball GT.",
//                "26 February 1986",
//                R.drawable.poster_dragon_ball
//            )
//        )
//        tvshows.add(
//            TvShow(
//                "tvshow4",
//                "Fairy Tail",
//                "6.6",
//                "Japanese",
//                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. " +
//                        "But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
//                "12 October 2009",
//                R.drawable.poster_fairytail
//            )
//        )
//        tvshows.add(
//            TvShow(
//                "tvshow5",
//                "Family Guy",
//                "6.5",
//                "English",
//                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - " +
//                        "a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
//                "31 January 1999",
//                R.drawable.poster_family_guy
//            )
//        )
//        tvshows.add(
//            TvShow(
//                "tvshow6",
//                "The Flash",
//                "6.7",
//                "English",
//                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally " +
//                        "the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
//                "07 October 2019",
//                R.drawable.poster_flash
//            )
//        )
//        tvshows.add(
//            TvShow(
//                "tvshow7",
//                "Game of Thrones",
//                "8.2",
//                "English",
//                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, " +
//                        "a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
//                "17 April 2011",
//                R.drawable.poster_god
//            )
//        )
//        tvshows.add(
//            TvShow(
//                "tvshow8",
//                "Gotham",
//                "6.8",
//                "English",
//                "veryone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? " +
//                        "And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
//                "22 September 2014",
//                R.drawable.poster_gotham
//            )
//        )
//        tvshows.add(
//            TvShow(
//                "tvshow9",
//                "Grey's Anatomy",
//                "6.2",
//                "English",
//                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
//                "27 Maret 2005",
//                R.drawable.poster_grey_anatomy
//            )
//        )
//        tvshows.add(
//            TvShow(
//                "tvshow10",
//                "Hanna",
//                "5.9",
//                "English",
//                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. " +
//                        "Based on the 2011 Joe Wright film.",
//                "28 Maret 2019",
//                R.drawable.poster_hanna
//            )
//        )
//        tvshows.add(
//            TvShow(
//                "tvshow11",
//                "Marvel's Iron Fist",
//                "6",
//                "English",
//                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, " +
//                        "he seeks to reclaim his past and fulfill his destiny.",
//                "17 Maret 2017",
//                R.drawable.poster_iron_fist
//            )
//        )
//        tvshows.add(
//            TvShow(
//                "tvshow12",
//                "Naruto Shippuden",
//                "7.5",
//                "Japanese",
//                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, " +
//                        "though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
//                "15 February 2007",
//                R.drawable.poster_naruto_shipudden
//            )
//        )
//        tvshows.add(
//            TvShow(
//                "tvshow13",
//                "NCIS",
//                "6.7",
//                "English",
//                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of " +
//                        "evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
//                "23 September 2003",
//                R.drawable.poster_ncis
//            )
//        )
//        tvshows.add(
//            TvShow(
//                "tvshow14",
//                "Riverdale",
//                "6.9",
//                "English",
//                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, " +
//                        "the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
//                "26 January 2017",
//                R.drawable.poster_riverdale
//            )
//        )
//        tvshows.add(
//            TvShow(
//                "tvshow15",
//                "Shameless",
//                "7.8",
//                "English",
//                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. " +
//                        "They may not be like any family you know, but they make no apologies for being exactly who they are.",
//                "09 January 2011",
//                R.drawable.poster_shameless
//            )
//        )
//        tvshows.add(
//            TvShow(
//                "tvshow16",
//                "Supergirl",
//                "5.7",
//                "English",
//                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, " +
//                        "until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
//                "26 October 2015",
//                R.drawable.poster_supergirl
//            )
//        )
//        tvshows.add(
//            TvShow(
//                "tvshow17",
//                "Supernatural",
//                "7.3",
//                "English",
//                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross " +
//                        "the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
//                "13 September 2005",
//                R.drawable.poster_supernatural
//            )
//        )
//        tvshows.add(
//            TvShow(
//                "tvshow18",
//                "The Simpsons",
//                "7.1",
//                "English",
//                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. " +
//                        "The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
//                "17 December 1989",
//                R.drawable.poster_the_simpson
//            )
//        )
//        tvshows.add(
//            TvShow(
//                "tvshow19",
//                "The Umbrella Academy",
//                "7.9",
//                "English",
//                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
//                "15 February 2019",
//                R.drawable.poster_the_umbrella
//            )
//        )
//        tvshows.add(
//            TvShow(
//                "tvshow20",
//                "The Walking Dead",
//                "7.3",
//                "English",
//                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
//                "31 October 2010",
//                R.drawable.poster_the_walking_dead
//            )
//        )
//
//        return tvshows
//    }
}