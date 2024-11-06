-- Create employees table
CREATE TABLE employees (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    department VARCHAR(100),
    role VARCHAR(100),
    salary DOUBLE
);

-- Insert initial data
INSERT INTO employees (name, department, role, salary) VALUES ('John Doe', 'HR', 'Manager', 50000);
INSERT INTO employees (name, department, role, salary) VALUES ('Jane Smith', 'IT', 'Developer', 40000);
