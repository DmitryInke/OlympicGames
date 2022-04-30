create table country
(
    cid        int auto_increment
        primary key,
    name       varchar(50)       not null,
    num_medals tinyint default 0 null,
    constraint name
        unique (name)
);

create table olympicgames
(
    start_date date not null,
    end_date   date not null
);

create definer = root@localhost trigger limit_rows
    before insert
    on olympicgames
    for each row
BEGIN
    DECLARE cnt INT;

    SELECT count(*) INTO cnt FROM OlympicGames;

    IF cnt = 1 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You can store only 1 records.';
    END IF;
END;

create definer = root@localhost trigger unique_value
    before insert
    on olympicgames
    for each row
BEGIN

    IF NEW.start_date = NEW.end_date THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You can not store the same date.';
    END IF;
END;

create table referee
(
    rid        int auto_increment
        primary key,
    country_id int         not null,
    sport_type tinyint     not null,
    name       varchar(50) not null,
    constraint unique_index
        unique (name, country_id, sport_type),
    constraint Referee_ibfk_1
        foreign key (country_id) references country (cid)
);

create index country_id
    on referee (country_id);

create table sportsman
(
    sid        int auto_increment
        primary key,
    country_id int         not null,
    sport_type tinyint     not null,
    name       varchar(50) not null,
    constraint unique_index
        unique (name, country_id, sport_type),
    constraint Sportsman_ibfk_1
        foreign key (country_id) references country (cid)
);

create index country_id
    on sportsman (country_id);

create table stadium
(
    sid      int auto_increment
        primary key,
    name     varchar(50) not null,
    address  varchar(50) not null,
    capacity int         not null,
    constraint unique_index
        unique (name, address)
);

create table competition
(
    cid              int auto_increment
        primary key,
    sport_type       tinyint     not null,
    stadium_id       int         not null,
    referee_id       int         not null,
    type_competition varchar(50) not null,
    constraint unique_index
        unique (stadium_id, referee_id, sport_type),
    constraint Competition_ibfk_1
        foreign key (stadium_id) references stadium (sid),
    constraint Competition_ibfk_2
        foreign key (referee_id) references referee (rid)
);

create index referee_id
    on competition (referee_id);

create table competitiontocompetitors
(
    competition_id int not null,
    competitor_id  int not null,
    constraint competitiontocompetitors_ibfk_1
        foreign key (competition_id) references competition (cid)
);

create index competition_id
    on competitiontocompetitors (competition_id);

create table team
(
    tid        int auto_increment
        primary key,
    sport_type tinyint not null,
    country_id int     not null,
    constraint unique_index
        unique (country_id, sport_type),
    constraint Team_ibfk_2
        foreign key (country_id) references country (cid)
);

create table sportsmentoteam
(
    team_id      int not null,
    sportsman_id int not null,
    constraint sportsmentoteam_ibfk_1
        foreign key (team_id) references team (tid)
);

create index team_id
    on sportsmentoteam (team_id);


