# Main Function
		global		main
		extern		malloc

		section		.text

# function gcd

__b_gcd_entry_1:
		push		r12
		push		rbx
		push		rbp
		mov		rbp, rsp
		mov		rbx, rsi
		mov		rax, rdi
		mov		r8, rdx
		cdq
		idiv		rbx
		mov		r10, rdx
		mov		rdx, r8
		and		r10, -1
		xor		rax, rax
		cmp		r10, 0
		sete		al
		mov		r10, rax
		cmp		r10, 1
		je		__b_if_then_1
__b_if_else_1:
		mov		rbx, rsi
		mov		rax, rdi
		mov		r8, rdx
		cdq
		idiv		rbx
		mov		r10, rdx
		mov		rdx, r8
		mov		r12, rsi
		mov		rbx, r10
		mov		rax, r12
		mov		r8, rdx
		cdq
		idiv		rbx
		mov		r11, rdx
		mov		rdx, r8
		and		r11, -1
		xor		rax, rax
		cmp		r11, 0
		sete		al
		mov		r11, rax
		cmp		r11, 1
		je		__b_if_then_2
		jmp		__b_if_else_2
__b_if_then_2:
		jmp		__b_gcd_end_1
__b_if_else_2:
		mov		rbx, r10
		mov		rax, r12
		mov		r8, rdx
		cdq
		idiv		rbx
		mov		r11, rdx
		mov		rdx, r8
		mov		r12, r11
		mov		rbx, r12
		mov		rax, r10
		mov		r8, rdx
		cdq
		idiv		rbx
		mov		r11, rdx
		mov		rdx, r8
		and		r11, -1
		xor		rax, rax
		cmp		r11, 0
		sete		al
		mov		r11, rax
		cmp		r11, 1
		je		__b_if_then_3
__b_if_else_3:
		mov		rbx, r12
		mov		rax, r10
		mov		r8, rdx
		cdq
		idiv		rbx
		mov		r10, rdx
		mov		rdx, r8
		mov		r11, r10
		mov		rbx, r11
		mov		rax, r12
		mov		r8, rdx
		cdq
		idiv		rbx
		mov		r10, rdx
		mov		rdx, r8
		and		r10, -1
		xor		rax, rax
		cmp		r10, 0
		sete		al
		mov		r10, rax
		cmp		r10, 1
		je		__b_if_then_4
		jmp		__b_if_else_4
__b_if_then_4:
		mov		r10, r11
		jmp		__b_gcd_end_2
__b_if_else_4:
		mov		rbx, r11
		mov		rax, r12
		mov		r8, rdx
		cdq
		idiv		rbx
		mov		r10, rdx
		mov		rdx, r8
		push		r11
		push		r10
		push		rdi
		push		rsi
		mov		rdi, r11
		mov		rsi, r10
		call		__b_gcd_entry_1
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		mov		r10, rax
__b_gcd_end_2:
		jmp		__b_gcd_end_3
__b_if_then_3:
		mov		r10, r12
__b_gcd_end_3:
__b_gcd_end_1:
		jmp		__b_gcd_end_4
__b_if_then_1:
		mov		r10, rsi
__b_gcd_end_4:
		mov		rax, r10
		pop		rbp
		pop		rbx
		pop		r12
		ret

# function main

main:
		push		r12
		push		rbx
		push		rbp
		mov		rbp, rsp
		pop		rbp
		pop		rbx
		pop		r12
__b__init_func_entry_1:
		mov		r10, 10
		mov		r11, 1
		mov		rbx, r11
		mov		rax, r10
		mov		r8, rdx
		cdq
		idiv		rbx
		mov		r12, rdx
		mov		rdx, r8
		and		r12, -1
		xor		rax, rax
		cmp		r12, 0
		sete		al
		mov		r12, rax
		cmp		r12, 1
		je		__b_if_then_5
__b_if_else_5:
		mov		rbx, r11
		mov		rax, r10
		mov		r8, rdx
		cdq
		idiv		rbx
		mov		r10, rdx
		mov		rdx, r8
		push		r11
		push		r10
		mov		rdi, r11
		mov		rsi, r10
		call		__b_gcd_entry_1
		pop		r10
		pop		r11
		mov		r10, rax
		jmp		__b_gcd_end_5
__b_if_then_5:
		mov		r10, r11
__b_gcd_end_5:
		push		r11
		push		r10
		mov		rdi, r10
		call		_Z10printlnInti
		pop		r10
		pop		r11
		mov		r12, 34986
		mov		r10, 3087
		mov		rbx, r10
		mov		rax, r12
		mov		r8, rdx
		cdq
		idiv		rbx
		mov		r11, rdx
		mov		rdx, r8
		and		r11, -1
		xor		rax, rax
		cmp		r11, 0
		sete		al
		mov		r11, rax
		cmp		r11, 1
		je		__b_if_then_6
		jmp		__b_if_else_6
__b_if_then_6:
		jmp		__b_gcd_end_6
__b_if_else_6:
		mov		rbx, r10
		mov		rax, r12
		mov		r8, rdx
		cdq
		idiv		rbx
		mov		r11, rdx
		mov		rdx, r8
		push		r11
		push		r10
		mov		rdi, r10
		mov		rsi, r11
		call		__b_gcd_entry_1
		pop		r10
		pop		r11
		mov		r10, rax
__b_gcd_end_6:
		push		r11
		push		r10
		mov		rdi, r10
		call		_Z10printlnInti
		pop		r10
		pop		r11
		mov		r11, 2907
		mov		r12, 1539
		mov		rbx, r12
		mov		rax, r11
		mov		r8, rdx
		cdq
		idiv		rbx
		mov		r10, rdx
		mov		rdx, r8
		and		r10, -1
		xor		rax, rax
		cmp		r10, 0
		sete		al
		mov		r10, rax
		cmp		r10, 1
		je		__b_if_then_7
__b_if_else_7:
		mov		rbx, r12
		mov		rax, r11
		mov		r8, rdx
		cdq
		idiv		rbx
		mov		r10, rdx
		mov		rdx, r8
		push		r11
		push		r10
		mov		rdi, r12
		mov		rsi, r10
		call		__b_gcd_entry_1
		pop		r10
		pop		r11
		mov		r10, rax
		jmp		__b_gcd_end_7
__b_if_then_7:
		mov		r10, r12
__b_gcd_end_7:
		push		r11
		push		r10
		mov		rdi, r10
		call		_Z10printlnInti
		pop		r10
		pop		r11
		mov		rax, 0
		ret


