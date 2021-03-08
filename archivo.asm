
este es un ejemplo%include 'functions.asm' 
SECTION .data 

msg0 db "cumple",0h

SECTION .bss
sinput: resb 255

dummy: resb 2

SECTION .text
global _start   
_start:
mov eax, msg0
call sprintLF 
call quit
