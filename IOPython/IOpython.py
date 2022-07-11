import pickle

class Clerk:
    def create(self):
        self.cid=int(input("Enter ID:"))
        self.name=input("Enter name:")
        self.age=int(input("Enter Age:"))
        self.salary=int(input("Enter Salary:"))
        
    def display(self):
        print("ID :",self.cid)
        print("Name :",self.name)
        print("Age :",self.age)
        print("salary :",self.salary)
        print("Designation : Clerk")
    def raiseSalary(self):
        self.salary=self.salary+20000
        print('salary :',self.salary)

class Manager:
    def create(self):
        self.mid=int(input("Enter ID:"))
        self.name=input("Enter name:")
        self.age=int(input("Enter Age"))
        self.salary=int(input("Enter Salary:"))
    def display(self):
        print("ID :",self.mid)
        print("Name :",self.name)
        print("Age :",self.age)
        print("Salary :",self.salary)
        print("Designation : Manager")
    def raiseSalary(self):
        self.salary=self.salary+20000
        print('salary :',self.salary)

class Tester:
    def create(self):
        self.tid=int(input("Enter ID:"))
        self.name=input("Enter name:")
        self.age=int(input("Enter Age"))
        self.salary=int(input("Enter Salary:"))
    def display(self):
        print("ID :",self.tid)
        print("Name :",self.name)
        print("Age :",self.age)
        print("salary :",self.salary)
        print("Designation :Developer")
    def raiseSalary(self):
        self.salary=self.salary+20000
        print('salary :',self.salary)
class Developer:
    def create(self):
        self.did= int(input("Enter ID:"))
        self.name=input("Enter name:")
        self.age=int(input("Enter Age"))
        self.salary=int(input("Enter Salary:"))
        
    def display(self):
        print("ID :",self.did)
        print("Name :",self.name)
        print("Age :",self.age)
        print("salary :",self.salary)
        print("Designation :Developer")
    def raiseSalary(self):
        self.salary=self.salary+20000
        print('salary :',self.salary)
print('1. Create ')		
print('2. Display ')
print('3. Raise Salary ')
print('4. Exit ')

C=Clerk()
M=Manager()
T=Tester()
D=Developer()


while True:
    n=int(input("Enter your choice :"))
    if n==1:
        print("1. Clerk")
        print("2. Manager ")
        print("3. Tester ")
        print("4. Developer ")
        print("Enter your choice:")
        n1=int(input())
        if n1==1:
            print("------Enter Clerk Details-------")
            C.create()
            with open('ltd', 'wb') as f:
                pickle.dump(C, f)
        elif n1==2:
            print("------Enter Manager Details------");
            M.create()
            with open('ltd', 'wb') as f:
                pickle.dump(M, f)
        elif n1==3:
            print("------Enter Tester Details-------");
            T.create()
            with open('ltd', 'wb') as f:
                pickle.dump(T, f)
        elif n1==4:
            print("------Enter Developer Details------");
            D.create()
            with open('ltd', 'wb') as f:
                pickle.dump(D, f)
        else:
            print("Exit")

    elif n==2:
        print("1. Clerk Details")
        print("2. Manager Details ")
        print("3. Tester Details")
        print("4. Developer Details")
        print("Enter your choice:");
        n2=int(input())
        if n2==1:
            print("------Displaying Clerk Details-------")
            with open('ltd', 'rb') as f:
                C = pickle.load(f)
            C.display()
        elif n2==2:
            print("------Displaying Manager Details-------")
            with open('ltd', 'rb') as f:
                M = pickle.load(f)
            M.display()
        elif n2==3:
            print("------Displaying Tester Details-------")
            with open('ltd', 'rb') as f:
                T = pickle.load(f)
            T.display()
        elif n2==4:
            print("------Displaying Developer Details-------")
            with open('ltd', 'rb') as f:
                D = pickle.load(f)
            D.display()
        else:
            print("Exiting from current Session....");

    elif n==3:
        print("Enter choice whose salary need to raise....")
        print("1. Clerk ")
        print("2. Manager ")
        print("3. Tester ")
        print("4. Developer ")
        print("Enter your choice:");
        n3=int(input())
        if n3==1:
            print("------Raising Salary of Clerk-------")
            with open('ltd', 'rb') as f:
                C = pickle.load(f)
            C.display()
            C.raiseSalary()
        elif n3==2:
            print("------Raising Salary Of Manager-------")
            with open('ltd', 'rb') as f:
                M = pickle.load(f)
            M.display()
            M.raiseSalary()
        elif n3==3:
            print("------Raising Salary Of Tester-------")
            with open('ltd', 'rb') as f:
                T = pickle.load(f)
            T.display()
            T.raiseSalary()
        elif n3==4:
            print("------Raising Salary Of Developer-------")
            with open('ltd', 'rb') as f:
                D = pickle.load(f)
            D.display()
            D.raiseSalary()
        else:
            print('exit')
            break
    else:
        print('exit')
        break
print("Thank You")
