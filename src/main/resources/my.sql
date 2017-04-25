CREATE TABLE Student (
    id int,
    first_name varchar(20) NOT NULL,
    middle_name varchar(20),
    last_name varchar(20) NOT NULL,
    mobile_no varchar(13),
    email_id varchar(50) NOT NULL,
    tagline varchar(100) NOT NULL,
    permanent_address varchar(100),
    city varchar(40),
    state varchar(10),
    zip char(6),
    country varchar(16),
    date_of_birth date NOT NULL,
    CONSTRAINT student_pk PRIMARY KEY (id)
);

CREATE TABLE education (
    id int,
    student_id int,
    university_id int,
    degree_id int,
    department_id int,
    attended_from date,
    attended_to date,
    cgpa_max int,
    cgpa_received int,
    cgpa_or_percentage_hide bool default false,
    department_rank int,
    department_rank_hide bool default false,
    classRank int,
    class_rank_hide bool default false,
    CONSTRAINT education_pk PRIMARY KEY (id),
    CONSTRAINT education_student_fk FOREIGN KEY education (student_id) REFERENCES student (id),
    CONSTRAINT education_university_fk FOREIGN KEY education (university_id) REFERENCES university (id),
    CONSTRAINT education_degree_fk FOREIGN KEY education (degree_id) REFERENCES degree (id),
    CONSTRAINT education_department_fk FOREIGN KEY education (department_id) REFERENCES department (id)
);

create table project (
	id int,
	student_id int,
	//TODO
	CONSTRAINT project_pk PRIMARY KEY (id),
	CONSTRAINT project_student_fk FOREIGN KEY project (student_id) REFERENCES student (id),
	//TODO
);