

class ClassA:

    def __init__(self, a: int, b: int):
        self.a = a
        self.b = b

    def getMe(self):
        return self.a + self.b


class ClassB(ClassA):
    def __init__(self, c, d):
        self.c = c
        self.d = d
        super().__init__(10, 10)

    def getMe(self):
        return self.a + self.b + self.c + self.d

