class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        for cha in s:
            if not stack and cha in '])}':
                return False
            if cha == ']':
                if stack[-1] != '[':
                    return False
                stack.pop()
            elif cha == ')':
                if stack[-1] != '(':
                    return False
                stack.pop()
            elif cha == '}':
                if stack[-1] != '{':
                    return False
                stack.pop()
            else:
                stack.append(cha)
        return not stack




